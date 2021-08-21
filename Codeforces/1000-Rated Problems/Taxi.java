import java.io.*;
import java.util.*;

public class Taxi {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int numberOfOnes = 0;
        int numberOfTwos = 0;
        int numberOfThrees = 0;
        int numberOfFours = 0;
        int comparator = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            comparator = Integer.parseInt(st.nextToken());
            if (comparator == 1) {
                numberOfOnes++;
            } else if (comparator == 2) {
                numberOfTwos++;
            } else if (comparator == 3) {
                numberOfThrees++;
            } else {
                numberOfFours++;
            }
        }

        total += numberOfFours;
        if (numberOfThrees < numberOfOnes) {
            total += numberOfThrees;
            numberOfOnes -= numberOfThrees;
            numberOfThrees = 0;
        } else if (numberOfOnes <= numberOfThrees) {
            total += numberOfOnes;
            numberOfThrees -= numberOfOnes;
            numberOfOnes = 0;
        }

        if (numberOfThrees > 0) {
            total += numberOfThrees;
            numberOfThrees = 0;
        }

        if (numberOfTwos > 0) {
            total += numberOfTwos / 2;
            numberOfTwos %= 2;
        }

        int leftoverTwosAndOnes = numberOfOnes + (2 * numberOfTwos);
        if (leftoverTwosAndOnes <= 4 && leftoverTwosAndOnes > 0) {
            total += 1;
        } else if (leftoverTwosAndOnes % 4 != 0) {
            total += (leftoverTwosAndOnes / 4) + 1;
        } else {
            total += leftoverTwosAndOnes / 4;
        }

        pw.println(total);
        pw.close();
    }
}
