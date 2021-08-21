import java.io.*;
import java.util.*;

public class BitPlusPlus {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int counter = 0; 

        for(int i = 0; i < n; i++) {
            String operation = r.readLine();
            if(operation.charAt(0) == '+' && operation.charAt(1) == '+' || 
                operation.charAt(1) == '+' && operation.charAt(2) == '+' ||
                    operation.charAt(0) == '+' && operation.charAt(2) == '+') {
                        counter++;
                    }
            else {
                counter--;
            }
        }
        pw.println(counter);
        pw.close();
    }
}
