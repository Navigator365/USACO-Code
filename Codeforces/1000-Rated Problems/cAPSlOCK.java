import java.io.*;
import java.util.*;

public class cAPSlOCK {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String keys = r.readLine();
        String ans = "";
        int counter = 0; 

        for(int i = 1; i < keys.length(); i++) {
            if(Character.isUpperCase(keys.charAt(i))) {
                counter++;
            }
        }
        if(counter == keys.length() - 1) {
            for(int i = 0; i < keys.length(); i++) {
                if(Character.isUpperCase(keys.charAt(i))) {
                    ans += Character.toLowerCase(keys.charAt(i));
                }
                else {
                    ans += Character.toUpperCase(keys.charAt(i));
                }
            }
            pw.println(ans);
            pw.close();
        }
        else {
            pw.println(keys);
            pw.close();
        }
    }
}
