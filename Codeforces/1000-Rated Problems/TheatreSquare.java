import java.io.*;
import java.util.*;

public class TheatreSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());
        double a = Integer.parseInt(st.nextToken());

        double answer = Math.ceil(n / a) * Math.ceil(m / a);

        pw.println((long) answer);
        pw.close();
    }
}
