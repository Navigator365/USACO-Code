/*
ID: battlef3
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];
        int maxMilkingTime = 0;
        int maxIdleTime = 0; 
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            startTimes[i] = Integer.parseInt(st.nextToken());
            endTimes[i] = Integer.parseInt(st.nextToken());
        }
        
        pw.println(maxMilkingTime + " " + maxIdleTime);
        pw.close();
    }
}
