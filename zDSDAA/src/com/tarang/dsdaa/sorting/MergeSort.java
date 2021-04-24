package com.tarang.dsdaa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 *  Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average and best) 
 *  as merge sort always divides the array into two halves and takes linear time to merge two halves.
 */
public class MergeSort {
	
	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		System.out.print("Unsorted array :");
		printArr(arr);
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("\nSorted array");
		printArr(arr);
		
	}	
		

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	private static void mergeSort(int[] arr, int l, int r) {
		
		if(l < r) {
			// Find the middle point
			int mid = l+(r-l)/2;
			
			// Sort first and second halves
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			
			// Merge the sorted halves
			merge(arr, l, mid, r);	
			
		}
	}

	// Merges two subarrays of arr[].First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	private static void merge(int[] arr, int l, int mid, int r) {
		
		int i= l, j = mid+1, k = l;
		int[] brr = new int[arr.length];
		
		while(i <= mid && j <= r) {
			if(arr[i] < arr[j]) {
				brr[k] = arr[i];
				i++;
			}
			else {
				brr[k] = arr[j];
				j++;
			}
			k++;
		}
		
		// when in above conditin any L or R sub array elements are left to merge
		if(i > mid) {
			while(j <= r) {
				brr[k] = arr[j];
				j++; 
				k++;
			}
		} else {
			while(i <= mid) {
				brr[k] = arr[i];
				i++;
				k++;
			}
		}
		
		for(k=l; k<=r;k++) {
			arr[k] = brr[k];
		}
		
	}
}
