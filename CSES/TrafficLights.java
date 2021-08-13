import java.io.*;
import java.util.*;

//CSES Problemset Traffic Lights
//Link: https://cses.fi/problemset/task/1163/
public class TrafficLights {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		// Just reading in the variables, we do this instead of Kattio for speed
		int streetLength = Integer.parseInt(st.nextToken());
		int trafficLights = Integer.parseInt(st.nextToken());

		// Using an array to read values since we can't get values from sets in Java
		int[] opArray = new int[trafficLights];
		TreeSet<Integer> streetPositions = new TreeSet<>();
		// Initialize the set with beginning and ending values
		streetPositions.add(0);
		streetPositions.add(streetLength);
		st = new StringTokenizer(r.readLine());

		// Fill the set with all street light locations
		for (int i = 0; i < trafficLights; i++) {
			int nextTrafficLight = Integer.parseInt(st.nextToken());
			opArray[i] = nextTrafficLight;
			streetPositions.add(nextTrafficLight);
		}
		r.close();

		int[] answer = new int[trafficLights];
		int prev = 0;
		int maxGap = 0;
		// Find the longest passage once all the streetlights are added
		for (int i : streetPositions) {
			maxGap = Math.max(i - prev, maxGap);
			prev = i;
		}
		answer[trafficLights - 1] = maxGap;
		/*
		 * Remove the streetlights in reverse order to how they were added, then find
		 * the gap created by removing each. Find the biggest current gap, and 
		 * add it to the next lowest index in answer.
		 */
		for (int i = trafficLights - 1; i > 0; i--) {
			streetPositions.remove(opArray[i]);
			int low = streetPositions.lower(opArray[i]);
			int high = streetPositions.higher(opArray[i]);
			maxGap = Math.max(maxGap, high - low);
			answer[i - 1] = maxGap;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : answer) {
			sb.append(i).append(" ");
		}
		pw.println(sb);
		pw.close();
	}
}
