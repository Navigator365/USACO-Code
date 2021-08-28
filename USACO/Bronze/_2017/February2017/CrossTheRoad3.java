package _2017.February2017;

import java.io.*;
import java.util.*;

//USACO 2017 February Contest, Bronze Problem 3
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=713
public class CrossTheRoad3 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

        int N = Integer.parseInt(r.readLine());

        int[] startTime = new int[N];
        int[] duration = new int[N];
        int totalQuestioning = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            startTime[i] = Integer.parseInt(st.nextToken());
            duration[i] = Integer.parseInt(st.nextToken());
        }

        boolean isQuestioning = false;
        for (int time = 1; time < 1000000; time++) {
            for (int i = 0; i < N; i++) {
                if(startTime[i] == time && startTime[i] >= totalQuestioning && isQuestioning) {
                    isQuestioning = false;
                }
                if (startTime[i] == time && !isQuestioning) {
                    totalQuestioning = startTime[i] + duration[i];
                    isQuestioning = true;
                } else if (startTime[i] == time && isQuestioning) {
                    totalQuestioning += duration[i];
                }
            }
        }
        pw.println(totalQuestioning);
        pw.close();
    }
}
