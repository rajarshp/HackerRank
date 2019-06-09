package com.sample.hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
 * INPUT
 * 6
 * 1 5 2 9 3 4
 */

public class InsersionSort2 {

	// Complete the insertionSort2 function below.
	static void insertionSort2(int n, int[] arr) {

		for (int i = 1; i < n; i++) {
			int key = arr[i]; // assume that till this point array is sorted
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j]; // shift right if values is less than the sorted element
				j = j - 1;
			}
			arr[j + 1] = key; // swap the position od the sorted element to it's correct position

			Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
			System.out.println();
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		insertionSort2(n, arr);

		scanner.close();
	}
}
