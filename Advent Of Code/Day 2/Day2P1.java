import java.io.*;
import java.util.*;

//Link: https://adventofcode.com/2021/day/2
public class Day2P1 {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("Advent Of Code/Day 2/commands.txt"));
    StringTokenizer st;

    final int K_MEASUREMENT_NUMS = 1000;
    int hoz = 0;
    int vert = 0;

    for (int i = 0; i < K_MEASUREMENT_NUMS; i++) {
      st = new StringTokenizer(r.readLine());
      String s = st.nextToken();
      int n = Integer.parseInt(st.nextToken());
      if (s.equals("up")) {
        vert -= n;
      } else if (s.equals("down")) {
        vert += n;
      } else {
        hoz += n;
      }
    }
    System.out.println(hoz * vert);
  }
}
