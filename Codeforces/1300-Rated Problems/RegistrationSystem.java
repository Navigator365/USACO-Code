import java.io.*;
import java.util.*;

public class RegistrationSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        HashMap<String, Integer> storageArr = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String currentName = r.readLine();
            if(!storageArr.containsKey(currentName)) {
                pw.println("OK");
                storageArr.put(currentName, 0);
            }
            else {
                pw.println(currentName + (storageArr.get(currentName) + 1));
                storageArr.put(currentName, (storageArr.get(currentName) + 1));
            }
        }
        pw.close();
    }
}
