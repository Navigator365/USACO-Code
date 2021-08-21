import java.io.*;
import java.util.*;

public class ChatRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s = r.readLine();
        String targetString = "hello";
        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == targetString.charAt(index)) {
                index += 1; 
            }
            if(index == 5) {
                pw.println("YES");
                pw.close();
                break;
            }
        }
        pw.println("NO");
        pw.close();
    }
}
