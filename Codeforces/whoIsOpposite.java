import java.io.*;
import java.util.*;

//https://codeforces.com/contest/1560/problem/B
public class whoIsOpposite {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int numberOfCases = Integer.parseInt(st.nextToken());
        int[] a = new int[numberOfCases];
        int[] b = new int[numberOfCases];
        int[] c = new int[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            st = new StringTokenizer(r.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < numberOfCases; i++) {
            int distance = 2 * Math.abs(a[i] - b[i]);
            if (c[i] > distance || c[i] + distance / 2 == b[i] 
                || c[i] + distance / 2 == a[i] || b[i] > distance
                    || a[i] > distance) {
                pw.println(-1);
            } else {
                if (c[i] + distance / 2 > distance) {
                    pw.println(c[i] - distance / 2);
                } else {
                    pw.println(c[i] + distance / 2);
                }
            }
        }
        pw.close();
    }
}
