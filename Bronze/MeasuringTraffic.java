import java.io.*;
import java.util.*;

//USACO 2019 February Contest, Bronze Problem 3
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=917
public class MeasuringTraffic {
    static final int infinity = 999999999;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("traffic.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] type = new String[N];
        int[] lowVal = new int[N];
        int[] highVal = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            type[i] = st.nextToken();
            lowVal[i] = Integer.parseInt(st.nextToken());
            highVal[i] = Integer.parseInt(st.nextToken());
        }

        int currMinValue = -infinity;
        int currMaxValue = infinity;
        int firstMinValue = -infinity;
        int firstMaxValue = infinity;

        for (int i = N - 1; i >= 0; i--) {
            if (type[i].equals("on")) {
                firstMinValue -= highVal[i];
                firstMaxValue -= lowVal[i];
                firstMinValue = Math.max(0, firstMinValue);
            } else if (type[i].equals("off")) {
                firstMinValue += lowVal[i];
                firstMaxValue += highVal[i];
            } else if (type[i].equals("none")) {
                firstMinValue = Math.max(firstMinValue, lowVal[i]);
                firstMaxValue = Math.min(firstMaxValue, highVal[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (type[i].equals("on")) {
                currMinValue += lowVal[i];
                currMaxValue += highVal[i];
            } else if (type[i].equals("off")) {
                currMinValue -= highVal[i];
                currMaxValue -= lowVal[i];
                currMinValue = Math.max(0, currMinValue);
            } else if (type[i].equals("none")) {
                currMinValue = Math.max(currMinValue, lowVal[i]);
                currMaxValue = Math.min(currMaxValue, highVal[i]);

            }
        }
        pw.println(firstMinValue + " " + firstMaxValue);
        pw.println(currMinValue + " " + currMaxValue);
        pw.close();
    }
}
