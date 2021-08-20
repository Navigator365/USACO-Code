import java.io.*;
import java.util.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw  = new PrintWriter(System.out);
        
        int w = Integer.parseInt(r.readLine());
        if(w > 2 && w % 2 == 0) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }

        pw.close();
    }
}
