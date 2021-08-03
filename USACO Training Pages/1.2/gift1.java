
/*
ID: battlef3
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    Map<String, Integer> people = new LinkedHashMap<>();
    ArrayList<String> els = new ArrayList<String>();

    String line = null;
    while ((line = r.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(line);
      while (st.hasMoreElements()) {
        els.add(st.nextToken());
      }
    }
    int np = Integer.parseInt(els.get(0));
    for (int i = 1; i <= np + 1; i++) {
      people.put(els.get(i), 0);
    }
    int offset = np;
    while (offset < els.size() - 1) {
      String name = els.get(offset + 1);
      int amount = Integer.parseInt(els.get(offset + 2));
      int recievers = Integer.parseInt(els.get(offset + 3));
      if (recievers > 0 && amount != 0) {
        int moneyForEach = Math.floorDiv(amount, recievers);
        for (int i = offset + 4; i < recievers + offset + 4; i++) {
          people.computeIfPresent(els.get(i), (k, v) -> v + moneyForEach);
        }
        people.computeIfPresent(name, (k, v) -> v - moneyForEach * recievers);
      }
      offset = recievers + offset + 3;
    }
    for (Map.Entry<String, Integer> person : people.entrySet()) {
      pw.println(person.getKey() + " " + person.getValue());
    }
    r.close();
    pw.close();
  }
}