package com.example.hackerrank.searching;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * INPUT
5 1
1 2 3 4 5
 */

public class HackerlandRadioTransmitters {

	// Complete the hackerlandRadioTransmitters function below.
	static int hackerlandRadioTransmitters(int[] x, int k) {

		TreeSet<Integer> tree = new TreeSet<Integer>(Arrays.stream(x).boxed().collect(Collectors.toList()));

		Integer value = tree.ceiling(0);

		int count = 0;
		while (value != null) {
			value = tree.floor(value + k);
			count++;
			value = tree.ceiling(value + k + 1);
		}

		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] x = new int[n];

		String[] xItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int xItem = Integer.parseInt(xItems[i]);
			x[i] = xItem;
		}

		int result = hackerlandRadioTransmitters(x, k);

		System.out.println(result);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
