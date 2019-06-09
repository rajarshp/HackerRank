package com.sample.hackerrank.sorting;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*
 * INPIT
 * 
6
31415926535897932384626433832795
1
3
10
3
5
 */

public class BigSorting {

	static int partition(String[] a, int start, int end) {
		String pivot = a[end];

		int left = start - 1;

		for (int j = start; j < end; j++) {

			BigInteger b1 = new BigInteger(a[j]);
			BigInteger b2 = new BigInteger(pivot);

			if (b1.compareTo(b2) <= 0) {
				left++;
				String temp = a[left];
				a[left] = a[j];
				a[j] = temp;
			}
		}
		String t = a[left + 1];
		a[left + 1] = a[end];
		a[end] = t;

		return left + 1;

	}

	static void sort(String[] a, int start, int end) {
		if (start < end) {
			int p = partition(a, start, end);

			sort(a, start, p - 1);
			sort(a, p + 1, end);

		}

	}

	// Complete the bigSorting function below.
	static String[] bigSorting(String[] unsorted) {

		// long[] a = new long[unsorted.length];
		// for(int i=0;i<a.length;i++){
		// a[i] = Long.parseLong(unsorted[i]);
		// }

		sort(unsorted, 0, unsorted.length - 1);

		return unsorted;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] unsorted = new String[n];

		for (int i = 0; i < n; i++) {
			String unsortedItem = scanner.nextLine();
			unsorted[i] = unsortedItem;
		}

		String[] result = bigSorting(unsorted);

		System.out.println(Arrays.toString(result));

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(result[i]);
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

		scanner.close();
	}
}
