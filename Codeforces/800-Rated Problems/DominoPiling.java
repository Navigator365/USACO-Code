import java.io.*;
import java.util.*;

public class DominoPiling {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        pw.println((int)Math.floor(n * m / 2));
        pw.close();
    }
}
