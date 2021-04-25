package com.tarang.dsdaa.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * It picks an element as pivot and partitions the given array around the picked pivot. 
 * Target of partitions is, given an array and an element x of array as pivot, put x at its correct position 
 * in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements 
 * (greater than x) after x. All this should be done in linear time.
 * Average and Best Time complexity - O(nLogn).
 * Worst Case Time complexity Theta(n2)
 */
public class QuickSort {

	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		System.out.print("Unsorted array :");
		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
		
		quicksort(arr, 0, arr.length-1);
		
		System.out.println("\nSorted array");
		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));

	}

	private static void quicksort(int[] arr, int l, int r) {
		if(l < r) {
			int pi = partition(arr, l, r);
			
			quicksort(arr, l, pi-1);
			
			quicksort(arr, pi+1, r);
			
		}
		
	}

	private static int partition(int[] arr, int l, int r) {
		
		int pivot = arr[r];
		int i = l-1;
		
		for(int j = l; j<=r-1; j++) {
			if(arr[j] < pivot) {
				i++;
				int tmp = arr[i];
				arr[i]  = arr[j];
				arr[j]  = tmp;
			}	
		}
		
		int tmp = arr[r];
		arr[r] = arr[i+1];
		arr[i+1] = tmp;
		
		return i+1;
		
	}

}

/*
 Why Quick Sort is preferred over MergeSort for sorting Arrays ?
 	Quick Sort - In place 
 	Merge Sort - requires O(N) extra storage 
 	
 	
 Why MergeSort is preferred over QuickSort for Linked Lists? 	
 
 	Merge Sort - Merge sort accesses data sequentially and the need of random access is low.(memory allocation) 
 	Quick Sort - lot of random access is reuired which is good with arrays 
 	
 	In case of linked lists the case is different mainly due to difference in memory allocation 
 	of arrays and linked lists.
 	
 	 Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list,
 	 we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation 
 	 of merge sort can be implemented without extra space for linked lists.
 */
