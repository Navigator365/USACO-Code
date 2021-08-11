import java.io.*;
import java.util.*;

//CSES Problemset Concert Tickets
//Link: https://cses.fi/problemset/task/1091/
public class ConcertTicketsUSACOVersion {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int numberOfTickets = Integer.parseInt(st.nextToken());
        int numberOfPeople = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> ticketMultiset = new TreeMap<Integer, Integer>();
        Map.Entry<Integer, Integer> val;

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < numberOfTickets; i++) {
            int priceOfTicket = Integer.parseInt(st.nextToken());
            if (ticketMultiset.containsKey(priceOfTicket))
                ticketMultiset.put(priceOfTicket, ticketMultiset.get(priceOfTicket) + 1);
            else
                ticketMultiset.put(priceOfTicket, 1);
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            int customerMaxPrice = Integer.parseInt(st.nextToken());
            val = ticketMultiset.lowerEntry(customerMaxPrice + 1);
            if (val != null) {
                pw.println(val.getKey());
                if (val.getValue() == 1)
                    ticketMultiset.remove(val.getKey());
                else
                    ticketMultiset.put(val.getKey(), val.getValue() - 1);
            } else
                pw.println(-1);
        }
        r.close();
        pw.close();
    }
}
