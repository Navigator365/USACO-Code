import java.io.*;
import java.util.*;

//USACO 2019 US Open Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=939
public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("buckets.out"));
        int barnX = 0, barnY = 0, lakeX = 0, lakeY = 0, rockX = 0, rockY = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            String row = st.nextToken();
            for (int k = 0; k < 10; k++) {
                if (row.charAt(k) == 'B') {
                    barnX = i;
                    barnY = k;
                } else if (row.charAt(k) == 'L') {
                    lakeX = i;
                    lakeY = k;
                } else if (row.charAt(k) == 'R') {
                    rockX = i;
                    rockY = k;
                }
            }
        }
        int cowsNeeded = Math.abs(barnX - lakeX) + Math.abs(barnY - lakeY) - 1;
        if (barnX == lakeX && barnX == rockX
                && ((lakeY < rockY && rockY < barnY) || (barnY < rockY && rockY < lakeY))) {
            cowsNeeded += 2;
        } else if (barnY == lakeY && barnY == rockY
                && ((lakeX < rockX && rockX < barnX) || (barnX < rockX && rockX < lakeX))) {
            cowsNeeded += 2;
        }
        pw.print(cowsNeeded);
        r.close();
        pw.close();
    }

}
