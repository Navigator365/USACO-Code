
/*
ID: battlef3
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("friday.out"));
        int years = Integer.parseInt(r.readLine()) - 1;
        int dayOfWeek = 2;
        int[] daysOfWeek13 = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        int[] daysInMonths = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 1900; i <= 1900 + years; i++) {
            boolean isLeapYear = false;
            if (i % 400 == 0) {
                isLeapYear = true;
            } else if (i % 100 == 0) {
                isLeapYear = false;
            } else if (i % 4 == 0) {
                isLeapYear = true;
            } else {
                isLeapYear = false;
            }
            if (isLeapYear) {
                daysInMonths[1] = 29;
            } else {
                daysInMonths[1] = 28;
            }
            for (int m : daysInMonths) {
                dayOfWeek += 12;
                dayOfWeek %= 7;
                daysOfWeek13[dayOfWeek]++;
                dayOfWeek += m - 12;
            }
        }
        pw.println(daysOfWeek13[0] + " " + daysOfWeek13[1] + " " + daysOfWeek13[2] + " " + daysOfWeek13[3] + " "
                + daysOfWeek13[4] + " " + daysOfWeek13[5] + " " + daysOfWeek13[6]);
        r.close();
        pw.close();
    }
}