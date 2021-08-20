import java.io.*;
import java.util.*;

public class NextRound {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int qualifiers = 0; 

        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int kVal = arr[k - 1];
            if(arr[i] >= kVal && arr[i] > 0) {
                qualifiers++;
            }
        }
        pw.println(qualifiers);
        pw.close();
    }
}
