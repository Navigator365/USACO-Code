import java.io.*;
import java.util.*;

//USACO 2017 US Open Contest, Bronze Problem 1
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=735
public class LostCow {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int distance = 0;
        int direction = 1;
        int mover = 1;

        // We don't have to hit Bessie on the end of our path,
        // but anywhere along each set of movement-thats why we <=/>=
        while (true) {
            if (direction == 1 && x <= y && y <= x + mover || direction == -1 && y <= x && x - mover <= y) {
                distance += Math.abs(y - x);
                break;
            } else {
                distance += mover * 2;
                mover *= 2;
                direction *= -1;
            }
        }
        pw.println(distance);
        r.close();
        pw.close();
    }
}
