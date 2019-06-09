package com.sample.hackerrank.sorting;

import java.util.ArrayList;
import java.util.Scanner;

class Matrices {
	public int a[][] = new int[3][3];
}

public class MagicSquare {

	private static ArrayList<Matrices> m = new ArrayList<>();// array list stores the all possible magic squares
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 3;
		int a[][] = { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } };
		int cost = 0;
		int min = 1000;
		int b[][];
		Matrices mat = new Matrices();
		// forms 8 magic squares from above matrix and adds to array list
		for (int i = 1; i <= 8; i++) {
			if (i == 1) {

				// 0th element
			} else if (i == 5) {
				// swapping the diagonals of the matrix
				swap(m.get(i - 2).a);
			} else {
				rotate(m.get(i - 2).a);
				// rotates the diagonals by 90 degrees
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				System.out.println(m.get(4).a[i][j]);
			}
		}
		mat.a = a;
		m.add(mat);

//		b = new int[3][3];
//		for (int p = 0; p < 3; p++) {
//			for (int j = 0; j < 3; j++) {
//				b[p][j] = scan.nextInt();
//			}
//		}
	}

//	}

//caluclating the cost
//
//		for (Matrices x : m) {
//			cost = 0;
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					cost += Math.abs(x.a[i][j] - b[i][j]);
//				}
//			}
//			if (cost < min) {
//				min = cost;
//
//			}
//		}
//		System.out.println(min);
//
//	}

	private static void rotate(int[][] a) {

		int b[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			int k = 2;
			for (int j = 0; j < 3; j++) {
				b[i][j] = a[k][i];
				k--;
			}
		}

		Matrices mat = new Matrices();
		mat.a = b;
		m.add(mat);
	}

	private static void swap(int[][] a) {

		int b[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b[j][i] = a[i][j];

			}

		}

		Matrices mat = new Matrices();
		mat.a = b;
		m.add(mat);
	}
}