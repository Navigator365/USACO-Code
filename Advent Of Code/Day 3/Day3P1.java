import java.io.*;
import java.util.*;

public class Day3P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("Advent Of Code/Day 3/binary.txt"));
        
        int K_MEASUREMENT_NUMS = 1000;
        int K_INDEX = 12;
        int max = 0;
        int min = 0;
        int[][] bits = new int[K_MEASUREMENT_NUMS][K_INDEX];

        for(int i = 0; i < K_MEASUREMENT_NUMS; i++) {
            String s = r.readLine();
            for(int j = 0; j < K_INDEX; j++) {
                bits[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }


        for(int i = 0; i < K_INDEX; i++) {
            int oneCounter = 0;
            for(int j = 0; j < K_MEASUREMENT_NUMS; j++) {
                if(bits[j][i] == 1) {
                    oneCounter++;
                }
            }
            if(2 * oneCounter > K_MEASUREMENT_NUMS) {
                max += Math.pow(2, K_INDEX - i - 1);
            }
            else {
                min += Math.pow(2, K_INDEX - i - 1);
            }
        }

        System.out.println(max * min);
    }
}
