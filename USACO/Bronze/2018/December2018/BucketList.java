import java.io.*;
import java.util.*;

//USACO 2018 December Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=856
public class BucketList {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blist.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int MAX_TIME = 1000;
        int N = Integer.parseInt(st.nextToken());
        int[] startTime = new int[N + 1];
        int[] endTime = new int[N + 1];
        int[] bucketsNeeded = new int[N + 1];
        int[] cowPairsStart = new int[MAX_TIME + 1];
        int[] cowPairsEnd = new int[MAX_TIME + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(r.readLine());
            startTime[i] = Integer.parseInt(st.nextToken());
            endTime[i] = Integer.parseInt(st.nextToken());
            bucketsNeeded[i] = Integer.parseInt(st.nextToken());

            cowPairsStart[startTime[i]] = i;
            cowPairsEnd[endTime[i]] = i;
        }

        int currentBuckets = 0;
        int maxBuckets = 0;

        for (int i = 1; i <= MAX_TIME; i++) {
            if (cowPairsStart[i] > 0) {
                currentBuckets += bucketsNeeded[cowPairsStart[i]];
            }
            maxBuckets = Math.max(currentBuckets, maxBuckets);
            if (cowPairsEnd[i] > 0) {
                currentBuckets -= bucketsNeeded[cowPairsEnd[i]];
            }
        }
        pw.println(maxBuckets);
        pw.close();
    }
}
