import java.io.*;
import java.util.*;

//USACO 2016 December Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=664
public class BlockGame {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] lettersNeeded = new int[26];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            int[] firstWordLetters = getLetters(firstWord);
            int[] secondWordLetters = getLetters(secondWord);

            for (int j = 0; j < 26; j++) {
                if (firstWordLetters[j] > secondWordLetters[j]) {
                    lettersNeeded[j] += firstWordLetters[j];
                } else {
                    lettersNeeded[j] += secondWordLetters[j];
                }
            }
        }

        for (int i : lettersNeeded) {
            pw.println(i);
        }
        pw.close();
    }

    public static int[] getLetters(String s) {
        int[] lettersNeeded = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            lettersNeeded[index]++;
        }
        return lettersNeeded;
    }
}
