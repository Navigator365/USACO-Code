import java.io.*;
import java.util.*;

//USACO 2020 January Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=987
public class WordProcessor {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int words = Integer.parseInt(st.nextToken());
        int maxLength = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int lineLength = 0;
        for (int i = 0; i < words; i++) {
            String currentWord = st.nextToken();
            if (currentWord.length() + lineLength > maxLength) {
                pw.print("\n" + currentWord);
                lineLength = currentWord.length();
            } else {
                // if there's any current words, add a space after them
                if (lineLength > 0) {
                    pw.print(" ");
                }
                pw.print(currentWord);
                lineLength += currentWord.length();
            }
        }
        r.close();
        pw.close();
    }
}
