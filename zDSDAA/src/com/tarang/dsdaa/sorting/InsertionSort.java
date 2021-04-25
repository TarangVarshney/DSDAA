package com.tarang.dsdaa.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * Time Complexity:O(n²) 
 * Insertion sort is used when number of elements is small.
 * The array is virtually split into a sorted and an unsorted part. 
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 */
public class InsertionSort {
	
	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Unsorted array "+line);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int[] sorted = insertionSort(arr, arr.length);
		
		for (int i : sorted) {
			System.out.print(i+" ");
		}
	}

	private static int[] insertionSort(int[] arr, int n) {
		
		int i,j, key;
		
		for(i = 1;i<n;i++) {
			
			// SELECTS the first unsorted element
			key = arr[i];
			
			//Shift large elements in left to one position right 
			j = i-1;
			while(j>=0 && key < arr[j]) {
				arr[j+1] =  arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		
		return arr;
	}
}
