import java.io.*;
import java.util.*;

//https://codeforces.com/contest/1560/problem/A
public class dislikeOfThrees {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int numberOfCases = Integer.parseInt(st.nextToken());

        while (numberOfCases > 0) {
            st = new StringTokenizer(r.readLine());
            int index = Integer.parseInt(st.nextToken());
            ArrayList<Integer> values = new ArrayList<Integer>();
            int counter = 1;
            int i = 1;

            while (values.size() <= index) {
                if (i % 3 != 0 && i % 10 != 3) {
                    values.add(i);
                    counter++;
                }
                i++;
            }
            pw.println(values.get(index - 1));
            numberOfCases--;
        }
        pw.close();
    }
}
