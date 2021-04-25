package com.tarang.dsdaa.sorting;

import java.util.Arrays;

/*
 * Time complexity of heapify is O(nLogn).
 */
public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		
		heapSort(arr);
		System.out.print("Sorted array is ");
		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));

	}

	private static void heapSort(int[] arr) {
		
		int n = arr.length;
		//i as non leaf node to start 
		for(int i = (n/2)-1; i>=0;i--) {
			heapify(arr, n, i);
		}
		
		//SWAP and REMOVE last node and call heapify
		for(int i = n-1; i>0;i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			heapify(arr, i, 0);
		}
		
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		// If left child is larger than root
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		
		// If right child is larger than largest so far
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		
		// SWAP If largest is not root or changed
		if(largest != i) {
			int tmp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = tmp;
			
			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

}
