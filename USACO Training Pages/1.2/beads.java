
/*
ID: battlef3
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("beads.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        String ogString = st.nextToken();
        ogString += ogString;
        int maxBeads = 0;

        for (int i = 0; i < ogString.length() - 1; i++) {
            int goingDown = i;
            int goingUp = i + 1;

            char currentDownBead = ogString.charAt(goingDown);
            char currentUpBead = ogString.charAt(goingUp);

            while (goingDown > 0) {
                if (currentDownBead == 'w' || ogString.charAt(goingDown - 1) == 'w'
                        || ogString.charAt(goingDown - 1) == currentDownBead) {
                    goingDown--;
                    //If the colors change, the outside if statement will fail and we will break the loop
                    if (ogString.charAt(goingDown) != 'w') {
                        currentDownBead = ogString.charAt(goingDown);
                    }
                } else {
                    break;
                }
            }

            while (goingUp < ogString.length() - 1) {
                if (currentUpBead == 'w' || ogString.charAt(goingUp + 1) == 'w'
                        || ogString.charAt(goingUp + 1) == currentUpBead) {
                    goingUp++;
                    if (ogString.charAt(goingUp) != 'w') {
                        currentUpBead = ogString.charAt(goingUp);
                    }
                } else {
                    break;
                }
            }
            maxBeads = Math.max(goingUp - goingDown + 1, maxBeads);
        }
        maxBeads = Math.min(maxBeads, N);
        pw.println(maxBeads);
        pw.close();
    }
}
