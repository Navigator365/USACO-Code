import java.io.*;
import java.util.*;

//USACO 2017 December Contest, Bronze Problem 3
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=761
public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));

        int n = Integer.parseInt(r.readLine());
        int[] day = new int[n];
        String[] name = new String[n];
        int[] change = new int[n];

        int mildredMilk = 7;
        int elsieMilk = 7;
        int bessieMilk = 7;

        boolean mildredTop = true;
        boolean elsieTop = true;
        boolean bessieTop = true;

        int boardChange = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken();
            change[i] = Integer.parseInt(st.nextToken());
        }

        for (int today = 1; today <= 100; today++) {
            for (int i = 0; i < n; i++) {
                if (day[i] == today) {
                    if (name[i].equals("Mildred")) {
                        mildredMilk += change[i];
                    } else if (name[i].equals("Bessie")) {
                        bessieMilk += change[i];
                    } else {
                        elsieMilk += change[i];
                    }
                }
            }

            int topCow = Math.max(mildredMilk, Math.max(bessieMilk, elsieMilk));

            boolean currMildredTop = mildredMilk == topCow;
            boolean currElsieTop = elsieMilk == topCow;
            boolean currBessieTop = bessieMilk == topCow;

            if (currMildredTop != mildredTop || currElsieTop != elsieTop || currBessieTop != bessieTop) {
                boardChange++;
            }

            mildredTop = currMildredTop;
            bessieTop = currBessieTop;
            elsieTop = currElsieTop;
        }

        pw.println(boardChange);
        pw.close();
    }
}
