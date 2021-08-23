import java.io.*;
import java.util.*;

//NOTE: This may not work! 
//ADDITIONAL NOTE: THIS DOESN'T! 
public class Dragons {

    public static class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int currentStrength = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<pair> strengthAndBonus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            strengthAndBonus.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(strengthAndBonus, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return Integer.valueOf(o1.x).compareTo(o2.x);
            }
        });

        for (int i = 0; i < n; i++) {
            int strengthReq = strengthAndBonus.get(i).x;
            if (!(currentStrength > strengthReq)) {
                pw.println("NO");
                pw.close();
                break;
            }
            currentStrength += strengthAndBonus.get(i).y;
        }
        pw.println("YES");
        pw.close();
    }
}
