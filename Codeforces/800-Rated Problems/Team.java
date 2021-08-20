import java.io.*;
import java.util.*;

public class Team {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        int[] v = new int[n];
        int[] t = new int[n];
        int counter = 0; 

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            if(p[i] == 1 && v[i] == 1 || p[i] == 1 && t[i] == 1 || t[i] == 1 && v[i] == 1) {
                counter++;
            }
        }
        pw.println(counter);
        pw.close();
    }
}
