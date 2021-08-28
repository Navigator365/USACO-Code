import java.io.*;
import java.util.*;

//USACO 2016 January Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=591
public class PromotionCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int bronzeInit = Integer.parseInt(st.nextToken());
        int bronzeAfter = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int silverInit = Integer.parseInt(st.nextToken());
        int silverAfter = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int goldInit = Integer.parseInt(st.nextToken());
        int goldAfter = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int platinumInit = Integer.parseInt(st.nextToken());
        int platinumAfter = Integer.parseInt(st.nextToken());

        // Cannot currently be in gold, silver or platinum, so take the current people
        // in each level and higher(could be promoted past the level), and subtract the
        // people who were there before (not promoted, stayed the same)
        int platinumPromotions = platinumAfter - platinumInit;
        int goldPromotions = goldAfter - goldInit + platinumPromotions;
        int silverPromotions = silverAfter - silverInit + goldPromotions;

        pw.println(silverPromotions);
        pw.println(goldPromotions);
        pw.println(platinumPromotions);

        r.close();
        pw.close();
    }
}