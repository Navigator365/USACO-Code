import java.io.*;
import java.util.*;

public class Resale {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());

        int[] values = new int[N];
        int[] costs = new int[N];
        int[] differences = new int[N];
        int maxDiff = 0; 

        StringTokenizer st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            differences[i] = values[i] - costs[i];
        }

        for(int i : differences) {
            int nextDiff = maxDiff;
            nextDiff += i; 
            maxDiff = Math.max(maxDiff, nextDiff);
        }

        pw.println(maxDiff);
        pw.close();
    }
}
