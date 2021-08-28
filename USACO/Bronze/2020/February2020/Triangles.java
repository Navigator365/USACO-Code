import java.io.*;
import java.util.*;

public class Triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        int[] coordinates = new int[2 * N];
        double maxArea = 0; 

        for(int i = 0; i < N; i+=2) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            coordinates[i] = Integer.parseInt(st.nextToken());
            coordinates[i + 1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i+=2) {
            double distanceA = 0; 
            double distanceB = 0; 
            double distanceC = 0; 
            double coordA1 = coordinates[i];
            double coordA2 = coordinates[i + 1];
            for(int j = i + 2; j < N; j += 2) {
                double coordB1 = coordinates[j];
                double coordB2 = coordinates[j + 1];
                for(int k = j + 2; k < N; k += 2) {
                    double coordC1 = coordinates[k];
                    double coordC2 = coordinates[k + 1];
                    distanceA = length(coordA1, coordA2, coordB1, coordB2);
                    distanceB = length(coordB1, coordB2, coordC1, coordC2);
                    distanceC = length(coordA1, coordA2, coordC1, coordC2);
                    double semiP = (distanceA + distanceB + distanceC) / 2.0; 
                    maxArea = Math.max(maxArea, semiP * (semiP - distanceA) * (semiP - distanceB) * (semiP - distanceC));
                }
            }
        }

        int maxArea2 = (int) maxArea;

        pw.println(maxArea2);
        pw.close();
    }

    static double length(double coordA1, double coordA2, double coordB1, double coordB2) {
        return Math.pow(coordA1 - coordA2, 2) + Math.pow(coordB1 - coordB2, 2);
    }
} 