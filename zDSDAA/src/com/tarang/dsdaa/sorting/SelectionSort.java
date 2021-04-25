package com.tarang.dsdaa.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * Time Complexity: O(n2)
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element 
 * (considering ascending order) from unsorted part and putting it at the beginning. 
 */
public class SelectionSort {
	
	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Unsorted array "+line);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int[] sorted = selectionSort(arr);
		
		for (int i : sorted) {
			System.out.print(i+" ");
		}
	}

	private static int[] selectionSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i =0; i<n-1;i++) {
			int min_index = i;
			
			// SELECTION
			for(int j = i+1; j<n-1;j++) {
				if(arr[min_index] > arr[j]) 
					min_index = j;
			}
			
			// SWAP the found minimum element with the first element
			int tmp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = tmp;
			
			// SHIFT COUNTER i++
		}
		
		return arr;
	}
}
