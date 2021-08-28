package _2016.February2016;

import java.io.*;
import java.util.*;

//First try!
//USACO 2016 February Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=616
public class CircularBarn {
    static final int infinity = 999999999;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));

        int n = Integer.parseInt(r.readLine());
        int[] cowsInPositions = new int[n];

        for(int i = 0; i < n; i++) {
            cowsInPositions[i] = Integer.parseInt(r.readLine());
        }

        int minDistance = infinity;
        for(int i = 0; i < n; i++) {
            int distance = 0;
            //Wrong: We're supposed to be going clockwise, not counterclockwise!
            for(int k = 0; k < i; k++) {
                distance += (cowsInPositions[k] * (Math.abs(n-i+k)));
            }
            for(int j = i; j < n; j++) {
                distance += (cowsInPositions[j] * (Math.abs(j-i)));
            }            
            minDistance = Math.min(distance, minDistance);
        }
        pw.println(minDistance);
        pw.close();
    }
}
