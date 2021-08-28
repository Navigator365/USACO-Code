package _2020.February2020;


import java.io.*;
import java.util.*;

//USACO 2020 February Contest, Bronze Problem 1
//Link: http://usaco.org/index.php?page=viewproblem2&cpid=1011
public class Triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));

        int N = Integer.parseInt(r.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        int maxArea = 0; 

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(y[i] == y[j] && x[i] == x[k]) {
                        int area = Math.abs((x[i] - x[j]) * (y[i] - y[k]));
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }


        pw.println(maxArea);
        pw.close();
    }
} 