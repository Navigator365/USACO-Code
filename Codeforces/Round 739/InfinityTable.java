import java.io.*;
import java.util.*;

//https://codeforces.com/contest/1560/problem/C
public class InfinityTable {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(r.readLine());
            long value = Integer.parseInt(st.nextToken());
            Double d = Double.valueOf(value);

            long partialSqrt = (int) Math.ceil(Math.sqrt(d));
            long absSqrt = (int) Math.sqrt(value);
            absSqrt *= absSqrt;

            if (value - absSqrt == 0) {
                pw.println(partialSqrt + " " + 1);
            } else if (value - absSqrt <= partialSqrt) {
                pw.println(value - absSqrt + " " + partialSqrt);
            } else {
                long overSquare = partialSqrt * partialSqrt;
                pw.println(partialSqrt + " " + (overSquare - value + 1));
            }
            testCases--;
        }
        pw.close();
    }
}
