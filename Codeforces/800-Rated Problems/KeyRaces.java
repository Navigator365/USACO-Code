import java.io.*;
import java.util.*;

public class KeyRaces {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int s = Integer.parseInt(st.nextToken());
        int vA = Integer.parseInt(st.nextToken());
        int vB = Integer.parseInt(st.nextToken());
        int tA = Integer.parseInt(st.nextToken());
        int tB = Integer.parseInt(st.nextToken());

        int first = s * vA + (2 * tA);
        int second = s * vB + (2 * tB);

        if(first == second) {
            pw.print("Friendship");
        }
        else if(first > second) {
            pw.print("Second");
        } 
        else {
            pw.print("First");
        }
        pw.close();
    }
}