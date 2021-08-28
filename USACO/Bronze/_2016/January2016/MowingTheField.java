package _2016.January2016;

import java.io.*;
import java.util.*;

//USACO 2016 January Contest, Bronze Problem 3
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=593
public class MowingTheField {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));

        int N = Integer.parseInt(r.readLine());
        int[][] grid = new int[2001][2001];
        int currX = 1000;
        int currY = 1000;
        int maxX = 1001;
        int currentTime = 0;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                grid[i][j] = -1;
            }
        }

        grid[currY][currX] = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            String direction = st.nextToken();
            int positions = Integer.parseInt(st.nextToken());
            int dirX = 0;
            int dirY = 0;

            if (direction.equals("N")) {
                dirX = 1;
            } else if (direction.equals("S")) {
                dirX = -1;
            } else if (direction.equals("E")) {
                dirY = 1;
            } else {
                dirY = -1;
            }

            for (int j = 0; j < positions; j++) {
                currX += dirX;
                currY += dirY;
                currentTime++;
                if (grid[currY][currX] >= 0 && currentTime - grid[currY][currX] < maxX) {
                    maxX = currentTime - grid[currY][currX];
                }
                grid[currY][currX] = currentTime;
            }
        }

        if(maxX == 1001) {
            maxX = -1; 
        } 

        pw.println(maxX);
        pw.close();
    }
}
