import java.io.*;
import java.util.*;


public class LuckyDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String n = r.readLine();
        int intN = Integer.parseInt(n);

        if(n.length() == 1) {
            if(intN == 7 || intN == 4 || intN == 8) {
                pw.println("YES");
                pw.close();
            }
            else {
                pw.println("NO");
                pw.close();
            }
        }
        else if(n.length() == 2) {
            if(n.charAt(1) == '7' && n.charAt(0) == '4' 
                || n.charAt(0) == '7' && n.charAt(1) == '4') {
                    pw.println("YES");
                    pw.close();    
                }
            else if(intN % 4 == 0 || intN % 7 == 0 || intN % 47 == 0) {
                pw.println("YES");
                pw.close();
            }
            else {
                pw.println("NO");
                pw.close();
            }
        }
        else {
            if((n.charAt(0) == '7' || n.charAt(0) == '4') && (n.charAt(1) == '4' || n.charAt(1) == '7')
                && (n.charAt(2) == '4' || n.charAt(2) == '7')) {
                    pw.println("YES");
                    pw.close();    
                }
            else if(intN % 4 == 0 || intN % 7 == 0 || intN % 47 == 0 
                || intN % 74 == 0 || intN % 474 == 0 || intN % 477 == 0) {
                    pw.println("YES");
                    pw.close();    
                }
            else {
                pw.println("NO");
                pw.close();
            }
        }
    }
}
