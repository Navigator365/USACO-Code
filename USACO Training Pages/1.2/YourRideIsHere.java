/*
ID: battlef3
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("ride.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int val1 = 1;
        int val2 = 1;  
        String s = st.nextToken();
        for(int i = 0; i < s.length(); i++) {
            val1 *= s.charAt(i) - 64;
        }
        st = new StringTokenizer(r.readLine());
        String t = st.nextToken();
        for(int i = 0; i < t.length(); i++) {
            val2 *= t.charAt(i) - 64;
        }
        if((val1 % 47) == (val2 % 47)) {
            pw.println("GO");
        }
        else{
            pw.println("STAY");
        }
        r.close();
        pw.close();
    }
}