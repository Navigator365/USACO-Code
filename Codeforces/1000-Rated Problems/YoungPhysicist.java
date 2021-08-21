import java.io.*;
import java.util.*;

public class YoungPhysicist {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());

        int firstSum = 0; 
        int secondSum = 0; 
        int thirdSum = 0; 

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            firstSum += Integer.parseInt(st.nextToken());
            secondSum += Integer.parseInt(st.nextToken());
            thirdSum += Integer.parseInt(st.nextToken());
        }

        if(firstSum == 0 && secondSum == 0 && thirdSum == 0) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }
        pw.close();
    }
}
