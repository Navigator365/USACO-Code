package _2018.February2018;

import java.io.*;
import java.util.*;

//USACO 2018 February Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=808
public class Hoofball {
	static int N;
	static int[] cows;

	// Which cow does a given cow pass to?
	public static int passToCow(int cow) {
		int leftCows = -1;
		int rightCows = -1;
		int leftRange = 1000;
		int rightRange = 1000;

		// For each cow, find closest cows to it on the left and right
		for (int i = 0; i < N; i++) {
			if (cows[i] < cows[cow] && cows[cow] - cows[i] < leftRange) {
				leftCows = i;
				leftRange = cows[cow] - cows[i];
			}
			if (cows[i] > cows[cow] && cows[i] - cows[cow] < rightRange) {
				rightCows = i;
				rightRange = cows[i] - cows[cow];
			}
		}

		// Return number of cows passing to the given cow
		if (leftRange <= rightRange) {
			return leftCows;
		}
		return rightCows;
	}

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("hoofball");

		N = io.nextInt();
		cows = new int[N];
		int ballsNeeded = 0;
		int[] cowsPassingTo = new int[N];

		for (int i = 0; i < N; i++) {
			cows[i] = io.nextInt();
		}

		// Let's classify each cow  
		for (int i = 0; i < N; i++) {
			cowsPassingTo[passToCow(i)]++;
		}

		for (int i = 0; i < N; i++) {
			// This is a source cow, so give it a ball
			if (cowsPassingTo[i] == 0) {
				ballsNeeded++;
			}
			// This cow only passes to 1 other cow forever, so give it a ball
			if (i < passToCow(i) && passToCow(passToCow(i)) == i && 
				cowsPassingTo[i] == 1 && cowsPassingTo[passToCow(i)] == 1) {
				ballsNeeded++;
			}
		}

		io.println(ballsNeeded);
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
