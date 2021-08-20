import java.io.*;
import java.util.*;

public class WayTooLongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        for (int i = 0; i < n; i++) {
            String word = r.readLine();
            if (word.length() < 11) {
                pw.println(word);
            } else {
                pw.println(word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1));
            }
        }
        pw.close();
    }
}
