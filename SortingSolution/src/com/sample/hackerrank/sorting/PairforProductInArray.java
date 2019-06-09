package com.sample.hackerrank.sorting;

public class PairforProductInArray {

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int index = start - 1;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				index++;
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;

			}

		}
		int temp = arr[index + 1];
		arr[index + 1] = arr[end];
		arr[end] = temp;

		return index++;

	}

	public static void sort(int[] arr, int start, int end) {

		if (start < end) {
			int p = partition(arr, start, end);

			sort(arr, start, p - 1);
			sort(arr, p + 1, end);
		}

	}

	public static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void findPair(int[] arr, int p) {
		int start = 0;
		int end = arr.length - 1;

		for (int i = 0; i <= end; i++) {
			if (arr[start] * arr[end] == p) {
				System.out.print("[" + arr[start] + "," + arr[end] + "], ");
				start++;
				end--;
			} else if (arr[start] * arr[end] > p) {
				start++;
			} else if (arr[start] * arr[end] > p) {
				end--;
			} else if (start >= end) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 9, 5, 4, 10 };

		sort(arr, 0, arr.length - 1);
		printArray(arr);
		findPair(arr, 20);

	}

}
