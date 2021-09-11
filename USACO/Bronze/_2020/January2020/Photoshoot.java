package _2020.January2020;

import java.io.*;
import java.util.*;

//USACO 2020 January Contest, Bronze Problem 2
//Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=988
public class Photoshoot {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("photo");

		int N = io.nextInt();
		int[] bessieList = new int[N];
		int[] correctList = new int[N];
		// Used to prevent repeated values in our permutation
		boolean[] isItThere = new boolean[N];

		for (int i = 1; i < N; i++) {
			bessieList[i] = io.nextInt();
		}

		// Iterate through every possible starting cow and see if we can
		// construct a permutation based on that.
		for (int i = 1; i <= N; i++) {
			correctList[0] = i;
			isItThere = new boolean[N];
			for (int j = 1; j < N; j++) {
				correctList[j] = bessieList[j] - correctList[j - 1];
			}
			boolean bad = false;
			for (int k : correctList) {
				// Our permutation isn't valid because there are unacceptable values
				// So, we can stop searching. 
				if (k > N || k <= 0) {
					bad = true;
					break;
				}
				else {
					// Our permutation isn't valid because some elements repeat
					if(isItThere[k - 1]) {
						bad = true;
						break;
					}
					else {
						isItThere[k - 1] = true;
					}
				}
			}
			// We've found a valid permutation since we started from 1, the 
			// first one we find will be the lexicographically smallest one
			if (!bad) {
				for (int j = 0; j < N; j++) {
					io.print(correctList[j]);
					if (j < N - 1) {
						io.print(" ");
					}
				}
				io.print("\n");
				io.close();
			}
		}
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
