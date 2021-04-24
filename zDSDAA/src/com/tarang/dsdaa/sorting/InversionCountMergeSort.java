package com.tarang.dsdaa.sorting;

import java.util.Arrays;

/*
 * Time Complexity: O(n^2)
 * Approach: Traverse through the array, and for every index, 
 * find the number of smaller elements on its right side of the array. 
 */
public class InversionCountMergeSort {

	public static void main(String[] args) {
		long[] arr = { 2, 4, 1, 3, 5 };

		long c = inversionCount(arr, arr.length);
		System.out.println(c);

	}

	private static long inversionCount(long[] arr, long N) {
		return mergeSortAndCount(arr, 0, N - 1);

	}

	private static long mergeSortAndCount(long[] arr, long l, long r) {

		// Keeps track of the inversion count at a
		// particular node of the recursion tree
		long count = 0;

		if (l < r) {
			long m = (l + r) / 2;

			// Total inversion count = left subarray count
			// + right subarray count + merge count

			// Left subarray count
			count += mergeSortAndCount(arr, l, m);

			// Right subarray count
			count += mergeSortAndCount(arr, m + 1, r);

			// Merge count
			count += mergeAndCount(arr, l, m, r);
		}

		return count;
	}

	private static long mergeAndCount(long[] arr, long l, long m, long r) {

		// Left subarray
		long[] left = Arrays.copyOfRange(arr, (int)l, (int)m + 1);

		// Right subarray
		long[] right = Arrays.copyOfRange(arr,(int)m + 1, (int)r + 1);

		long i = 0, j = 0, k = l, swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[(int)i] <= right[(int)j])
				arr[(int) k++] = left[(int) i++];
			else {
				arr[(int) k++] = right[(int) j++];
				swaps += (m + 1) - (l + i);
			}
		}
		while (i < left.length)
			arr[(int) k++] = left[(int) i++];
		while (j < right.length)
			arr[(int) k++] = right[(int) j++];
		return swaps;
	}

//	private static void inversionCount(long[] arr, int N) {
//		long inv_count = 0;
//		for (long i = 0; i < N - 1; i++) {
//			for (long j = i + 1; j < N; j++) {
//				if (arr[(int) i] > arr[(int) j])
//					inv_count++;
//			}
//
//		}
//		System.out.println(inv_count);
//	}
}
