import java.io.*;
import java.util.*;

public class TrafficLights { 
	public static void main(String[] args) throws IOException { 
		Kattio io = new Kattio();

		int streetLength = io.nextInt();
		int lightNum = io.nextInt();

		// Using an array to read values since we can't get values from sets in Java
		int[] opArray = new int[lightNum];
		NavigableSet<Integer> streetPositions = new TreeSet<>();
		// Initialize the set with beginning and ending values
		streetPositions.add(0);
		streetPositions.add(streetLength);
		for (int i = 0; i < lightNum; i++) {
			int nextTrafficLight = io.nextInt();
			opArray[i] = nextTrafficLight;
			streetPositions.add(nextTrafficLight);
		}

		int[] gapsArray = new int[lightNum];
		int prev = 0;
		int maxGap = 0;
		// Find the longest passage once all the streetlights are added
		for (int i : streetPositions) {
			maxGap = Math.max(i - prev, maxGap);
			prev = i;
		}
		gapsArray[lightNum - 1] = maxGap;
		/*
		 * Remove the streetlights in reverse order to how they were added, then find
		 * the gap created by removing each. Find the biggest current gap, and
		 * add it to the next lowest index in answer.
		 */
		for (int i = lightNum - 1; i > 0; i--) {
			streetPositions.remove(opArray[i]);
			int low = streetPositions.lower(opArray[i]);
			int high = streetPositions.higher(opArray[i]);
			maxGap = Math.max(maxGap, high - low);
			gapsArray[i - 1] = maxGap;
		}
		for (int i : gapsArray) {
			io.print(i + " ");
		}
		io.close();
	}
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
	
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
	
		public int nextInt() { return Integer.parseInt(next()); }
	}	
}
