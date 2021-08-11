import java.io.*;
import java.util.*;

public class ConcertTickets {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int numberOfTickets = io.nextInt();
        int numberOfPeople = io.nextInt();
        /*
         * Since Java doesn't have its own multiset method like C++, we'll have 
         * to use a regular ordered set
         */
        TreeMap<Integer, Integer> ticketMultiset = new TreeMap<Integer, Integer>();
        Map.Entry<Integer, Integer> val;

        // Read the ticket prices into the multiset
        for (int i = 0; i < numberOfTickets; i++) {
            int priceOfTicket = io.nextInt();
            /*
             * If the set already contains the same key value, just create another pair 
             * right next to it
             */
            if (ticketMultiset.containsKey(priceOfTicket))
                ticketMultiset.put(priceOfTicket, ticketMultiset.get(priceOfTicket) + 1);
            else
                ticketMultiset.put(priceOfTicket, 1);
        }

        for (int i = 0; i < numberOfPeople; i++) {
            int customerMaxPrice = io.nextInt();
            /*
             * Of all ticket prices, get the pair of the greatest possible 
             * ticket price less than the maximum.
             * We add 1 to customerMaxPrice just in case the maximum price is 
             * the price of a ticket, as lowerEntry only returns sets with 
             * strictly lower entries. 
             * We're using an ordered map here since we're using a multiset, 
             * which means we have to manually remove each set with identical 
             * keys. We'll need the entire set to do that, though, so we get it here. 
             */
            val = ticketMultiset.lowerEntry(customerMaxPrice + 1); 
            /*
             * If there is no lower price, the answer will be null, 
             * so there's no possible prices, so we can exit and return -1
             */
            if (val != null) {
                io.println(val.getKey());
                /**
                 * If there's more than one set with the key value, then replace
                 * the current set with the next-lowest set with the same key 
                 */
                if (val.getValue() == 1)
                    ticketMultiset.remove(val.getKey());
                else
                    ticketMultiset.put(val.getKey(), val.getValue() - 1);
            } else
                io.println(-1);
        }
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}