package _2019.December2019;

import java.io.*;
import java.util.*;

public class CowGymnastics {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
		StringTokenizer st = new StringTokenizer(r.readLine());

		boolean[][] completePairs = new boolean[20][20];
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int line[] = new int[n];
		int count = 0;

		while (k != 0) {
			st = new StringTokenizer(r.readLine());

			for (int i = 0; i < n; i++) {
				line[i] = Integer.parseInt(st.nextToken());
			}

			// Working from highest to lowest rank, create each pair
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					completePairs[line[i] - 1][line[j] - 1] = true;
				}
			}
			k--;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// If both pairs are true, then the pair must have changed order
				// during the competition
				if (!completePairs[i][j] || !completePairs[j][i]) {
					count++;
				}
			}
		}

		pw.println(count);
		pw.close();
	}
}
