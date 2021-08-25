import java.io.*;
import java.util.*;

public class Stars {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        String S = r.readLine();
        int K = Integer.parseInt(r.readLine());
        char KTarget = S.charAt(K - 1);

        char[] replace = new char[N];

        for(int i = 0; i < N; i++) {
            if(S.charAt(i) == KTarget) {
                replace[i] = KTarget;
            }
            else {
                replace[i] = '*';
            }
        }
        String print = "";
        for(char c : replace) {
            print += c; 
        }

        pw.println(print);
        pw.close();
    }
}
