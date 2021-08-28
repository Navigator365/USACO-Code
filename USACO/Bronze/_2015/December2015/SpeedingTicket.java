package _2015.December2015;

import java.io.*;
import java.util.*;

//USACO 2015 December Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=568
public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] speedLimits = new int[100];
        int currDistance = 0;
        int[] bessieSpeed = new int[100];
        int bessieCurrDistance = 0;
        int maxOverLimit = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j++) {
                speedLimits[currDistance] = limit;
                currDistance++;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j++) {
                bessieSpeed[bessieCurrDistance] = limit;
                bessieCurrDistance++;
            }
        }

        for (int i = 0; i < 100; i++) {
            maxOverLimit = Math.max(maxOverLimit, 
                Math.max(bessieSpeed[i] - speedLimits[i], 0));
        }
        pw.println(maxOverLimit);
        r.close();
        pw.close();
    }
}
