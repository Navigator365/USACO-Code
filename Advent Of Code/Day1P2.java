import java.io.*;
import java.util.*;

//Link: https://adventofcode.com/2021/day/1
public class Day1P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("Advent Of Code/depths.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        final int K_MEASUREMENT_NUMS = 2000;
        int numOfIncreases = 0;
        int[] depths = new int[K_MEASUREMENT_NUMS];

        for (int i = 0; i < K_MEASUREMENT_NUMS; i++) {
            depths[i] = Integer.parseInt(r.readLine());
        }

        for (int i = 0; i < K_MEASUREMENT_NUMS; i++) {
            if (i < K_MEASUREMENT_NUMS - 3) {
                if (depths[i] + depths[i + 1] + depths[i + 2] < depths[i + 1] + depths[i + 2] + depths[i + 3]) {
                    numOfIncreases++;
                }
            }
        }
        System.out.println(numOfIncreases);
    }
}
