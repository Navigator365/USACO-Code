package _2020.December2020;

import java.io.*;
import java.util.*;

//FIRST TRY! 
//USACO 2020 December Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=1059#
public class DoYouKnowYourABCS {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int[] values = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        Arrays.sort(values);

        if (values[0] == values[1] && values[1] == values[2]) {
            pw.print(values[0] + " ");
            pw.print(values[0] + " ");
            pw.print(values[0]);
        }
        int a = values[6] - values[5];
        int b = values[6] - values[4];
        int c = values[4] - a;

        pw.print(a + " ");
        pw.print(b + " ");
        pw.print(c);

        r.close();
        pw.close();
    }
}
