import java.io.*;
import java.util.*;


//Link: https://adventofcode.com/2021/day/1
public class Day1P1 {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("Advent Of Code/Day 1/depths.txt"));
    
    final int K_MEASUREMENT_NUMS= 2000; 
    int prevVal = Integer.parseInt(r.readLine());
    int currVal;
    int numOfIncreases = 0; 
        
    for(int i = 0; i < K_MEASUREMENT_NUMS - 1; i++) {
      currVal = Integer.parseInt(r.readLine());
      if(currVal > prevVal) {
        numOfIncreases++;
      }
      prevVal = currVal;
    }
    System.out.println(numOfIncreases);
  }
}
