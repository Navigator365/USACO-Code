import java.io.*;
import java.util.*;

public class XeniaAndRingroad {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] houseAddresses = new int[m + 1];
        houseAddresses[0] = 1;
        long distance = 0; 

        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < m; i++) {
            houseAddresses[i + 1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < m + 1; i++) {
            int prevAddress = houseAddresses[i - 1];
            int currentAddress = houseAddresses[i];
            if(prevAddress <= currentAddress) {
                distance += currentAddress - prevAddress;
            }
            else {
                distance += n - prevAddress + currentAddress;
            }
        }

        pw.println(distance);
        pw.close();
    }
}
