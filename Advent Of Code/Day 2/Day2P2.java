import java.io.*;
import java.util.*;

//Link: https://adventofcode.com/2021/day/2
public class Day2P2 {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("Advent Of Code/Day 2/commands.txt"));
    StringTokenizer st;

    final int K_MEASUREMENT_NUMS = 1000;
    int aim = 0;
    int depth = 0;
    int hoz = 0; 

    for(int i = 0; i < K_MEASUREMENT_NUMS; i++) {
        st = new StringTokenizer(r.readLine());
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        if(s.equals("down")) {
            aim += n;
        }
        else if(s.equals("up")) {
            aim -= n;
        }
        else {
            hoz += n;
            depth += (aim * n);
        }

    }
    System.out.println(hoz * depth);

  }
}
