package com.tarang.dsdaa.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * Worst and Average Case Time Complexity: O(n2). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * 
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent 
 * elements if they are in wrong order.
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Unsorted array "+line);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int[] sorted = bubbleSort(arr, arr.length);
		
		for (int i : sorted) {
			System.out.print("Sorted array is "+i+" ");
		}
	}

	private static int[] bubbleSort(int[] arr, int n) {
		
		int i,j;
		boolean swapped;
		for(i=0;i<n-1;i++) {
			swapped = false;
			for(j=0;j<n-i-1;j++) {
				if(arr[j+1] < arr[j]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
					swapped = true;
				}
			}
			
			// IF no two elements were swapped by inner loop, then break
			if(swapped == false) 
				break;
		}
		
		return arr;
	}
}
