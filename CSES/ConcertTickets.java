import java.io.*;
import java.util.*;

//CSES Problemset Concert Tickets
//Link: https://cses.fi/problemset/task/1091/
public class ConcertTickets {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();

		int ticketNum = io.nextInt();
		int peopleNum = io.nextInt();
		// No multiset in java so we'll have to use a TreeMap
		TreeMap<Integer, Integer> ticketMultiset = new TreeMap<>();
		Map.Entry<Integer, Integer> val;

		for (int i = 0; i < ticketNum; i++) {
			int priceOfTicket = io.nextInt();
			/*
			 * If the set already contains the same key value, create another pair 
			 * next to it
			 */
			if (ticketMultiset.containsKey(priceOfTicket)) {
				ticketMultiset.put(priceOfTicket, ticketMultiset.get(priceOfTicket) + 1);
			} else {
				ticketMultiset.put(priceOfTicket, 1);
			}
		}

		for (int i = 0; i < peopleNum; i++) {
			int customerMaxPrice = io.nextInt();
			/*
			 * Get the optimal ticket for this customer 
			 * We add 1 because lowerEntry returns the highest *strictly* lower entry
			 */
			val = ticketMultiset.lowerEntry(customerMaxPrice + 1); 
			// If there are no possible prices, we can exit and return -1
			if (val != null) {
				io.println(val.getKey());
				/*
				 * If there's more than one set with the key value, then replace
				 * the current set with the next-lowest set with the same key 
				 */
				if (val.getValue() == 1) {
					ticketMultiset.remove(val.getKey());

				} else {
					ticketMultiset.put(val.getKey(), val.getValue() - 1);
				}
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