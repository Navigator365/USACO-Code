import java.io.*;
import java.util.*;

public class IQtest {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());

        int evenCounter = 0; 
        int evenIndex = 0; 
        int oddCounter = 0; 
        int oddIndex = 0; 
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(st.nextToken());
            if(currentNum % 2 == 0) {
                evenCounter++;
                evenIndex = i + 1;
            }
            else {
                oddCounter++;
                oddIndex = i + 1;
            }
        }

        if(evenCounter == n - 1) {
            pw.println(oddIndex);
        }
        else {
            pw.println(evenIndex);
        }
        pw.close();
    }
}
