package com.sample.hackerrank.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort1 {

	// Complete the quickSort function below.
	static int[] quickSort(int[] arr) {
		int p = arr[0];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		int i = -1;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < p) {
				i++;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// int t = arr[i+1];
		// arr[i+1] = arr[arr.length-1];
		// arr[arr.length-1] = t;
		return arr;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = quickSort(arr);

		System.out.println(Arrays.toString(result));

		scanner.close();
	}
}
