import java.io.*;
import java.util.*;

//USACO 2017 December Contest, Bronze Problem 2 (No help needed)
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=760
public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        int[] cowIds = new int[N];
        int[] cowIdsOutput = new int[N];

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            cowIds[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < N; k++) {
                int movingValue = sequence[k] - 1;
                cowIdsOutput[k] = cowIds[movingValue];
            }
            for (int m = 0; m < N; m++) {
                cowIds[m] = cowIdsOutput[m];
            }
        }
        for (int i : cowIdsOutput) {
            pw.println(i);
        }
        r.close();
        pw.close();
    }
}
