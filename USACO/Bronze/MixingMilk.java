import java.io.*;
import java.util.*;

//USACO 2018 December Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=855
public class MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int maxA = Integer.parseInt(st.nextToken());
        int currA = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int maxB = Integer.parseInt(st.nextToken());
        int currB = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int maxC = Integer.parseInt(st.nextToken());
        int currC = Integer.parseInt(st.nextToken());

        // Somewhat inefficient way to do this with the if statements-we can just
        // take the minimum of currX and MaxY-currY and pour that amount
        for (int i = 0; i < 33; i++) {
            if (currA + currB <= maxB) {
                currB += currA;
                currA = 0;
            } else {
                currA -= maxB - currB;
                currB = maxB;
            }
            if (currB + currC <= maxC) {
                currC += currB;
                currB = 0;
            } else {
                currB -= maxC - currC;
                currC = maxC;
            }
            if (currC + currA <= maxA) {
                currA += currC;
                currC = 0;
            } else {
                currC -= maxA - currA;
                currA = maxA;
            }
        }

        if (currA + currB <= maxB) {
            currB += currA;
            currA = 0;
        } else {
            currA -= maxB - currB;
            currB = maxB;
        }

        pw.println(currA); // should be currA
        pw.println(currB); // should be currB
        pw.println(currC);
        r.close();
        pw.close();
    }
}
