import java.io.*;
import java.util.*;

//USACO 2016 December Contest, Bronze Problem 3
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=665
public class CowSignal {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Fill the array with the signal picture
        for (int i = 0; i < m; i++) {
            String signal = r.readLine();
            for (int q = 0; q < k; q++) {
                for (int j = 0; j < n; j++) {
                    for (int p = 0; p < k; p++) {
                        // Java prints out a single character
                        pw.print(signal.charAt(j));
                    }
                }
                // This in Java simply goes to a new line-use this instead of \n
                pw.println();
            }
        }
        r.close();
        pw.close();
    }
}
