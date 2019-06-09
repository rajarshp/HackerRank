package com.sample.hackerrank.sorting;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FullSort {

	// Complete the countSort function below.
	static void countSort(List<List<String>> arr, int n) {
		String[][] a = arr.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new);

		/* Create HashMap with empty "buckets" to put Strings into */
		HashMap<Integer, ArrayList<String>> map = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<String>());
		}

		for (int i = 0; i < n; i++) {
			int key = Integer.valueOf(a[i][0]);
			String value = (i < n / 2) ? "-" : a[i][1];

			List<String> list = map.get(key);
			list.add(value);
		}

		/* Print output */
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			List<String> values = map.get(i);
			for (String str : values) {
				sb.append(str + " ");
			}
		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		countSort(arr, n);

		bufferedReader.close();
	}
}
