import java.io.*;
import java.util.*;

public class Expression {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());

        int pos1 = a * b * c; 
        int pos2 = (a*b)+c;
        int pos3 = a+(b*c);
        int pos4 = (a+b)*c;
        int pos5 = a*(b+c);
        int pos6 = a + b*c; 
        int pos7 = a*b + c; 
        int pos8 = a+b+c;

        pw.println(Math.max(Math.max(Math.max(Math.max(
            Math.max(Math.max(Math.max(pos1, pos2), pos3), pos4), pos5), pos6), pos7), pos8));
        pw.close();
    }    
}
