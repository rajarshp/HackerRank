package com.sample.hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FraudulentActivityNotifications {

	public static double getMedian(int[] ar, int d) {

//		int[] tarr = ar.clone();
		double median;
		Arrays.sort(ar);
		// double median;
		if (d % 2 == 0) {
			median = ((double) ar[d / 2] + (double) ar[d / 2 - 1]) / 2;
		} else {
			median = (double) ar[d / 2];
		}
		return median;
	}

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {

		// Arrays.sort(expenditure);
		int s = expenditure.length;
		double median;
		int count = 0;

		// if (s % 2 == 0){
		// median = ((double)expenditure[s/2] + (double)expenditure[s/2 - 1])/2;
		// }
		// else{
		// median = (double) expenditure[s/2];
		// }
		int j = 0;
		for (int i = d; i < s; i++) {
			int[] t = new int[d];

			if (d + j <= s) {

				for (int k = 0; k < d; k++) {
					t[k] = expenditure[k + j];

				}

				median = getMedian(t, d);
				if ((median * 2) <= expenditure[d + j]) {
					count++;
				}
			}
			j++;
		}

		return count;
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		// String[] nd = scanner.nextLine().split(" ");

		// int n = Integer.parseInt(nd[0]);

		// int d = Integer.parseInt(nd[1]);

		// int[] expenditure = new int[n];

		// String[] expenditureItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nd = br.readLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);
		System.out.println(result);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		// scanner.close();
	}
}
