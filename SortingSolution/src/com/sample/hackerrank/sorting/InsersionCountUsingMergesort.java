package com.sample.hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsersionCountUsingMergesort {

	public static int count = 0;

	public static void merge(int[] a, int left, int mid, int right) {
		int l = (mid - left + 1); // left array index
		int r = (right - mid); // right array index

		// create left & right array

		int[] leftArray = new int[l];
		int[] rightArray = new int[r];

		// copy left array
		for (int i = 0; i < l; i++) {
			leftArray[i] = a[left + i];
		}

		// copy right array
		for (int j = 0; j < r; j++) {
			rightArray[j] = a[mid + 1 + j];
		}

		// index for sub arrays

		int i = 0;
		int j = 0;
		int k = left;

		// merge the array

		while (i < l && j < r) {

			if (leftArray[i] <= rightArray[j]) {
				a[k] = leftArray[i];
				i++;
			} else {
				a[k] = rightArray[j];
				j++;
				count += leftArray.length - i;
			}
			k++;
		}

		// copy rest of left array

		while (i < l) {
			a[k] = leftArray[i];
			i++;
			k++;
		}

		// copy rest of right array

		while (j < r) {
			a[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int[] a, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);

			merge(a, start, mid, end);

		}

	}

	// Complete the insertionSort function below.
	static int insertionSort(int[] arr) {
		count = 0;

		mergeSort(arr, 0, arr.length - 1);

		return count;
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		// int t = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			// int n = scanner.nextInt();
			// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];

			// String[] arrItems = scanner.nextLine().split(" ");
			// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] arrItems = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int result = insertionSort(arr);

			System.out.println(result);

			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		// scanner.close();
	}
}
