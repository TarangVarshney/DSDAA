package com.tarang.dsdaa.searching;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * provided sorted array
 * reduced tie complexity to O(Log n) base3
 *  divide and conquer algorithm 
 * Ternary Search does more comparisons than Binary Search in worst case.
 */
public class TernarySearch {

	public static void main(String[] args) {
		
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Enter key to search ");
		int key = sc.nextInt();
		
		System.out.println("Array "+line+" Key is "+key);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		//int response = ternarySearch(arr, 0, arr.length-1, key);
		int response = ternarySearch(arr, key);
		
		if(response != -1)
			System.out.println("Key found at "+response);
		else 
			System.out.println("Key does not found");

	}

	private static int ternarySearch(int[] arr,int start, int end, int key) {
		
		int mid1 = start+(end-start)/3;
		int mid2 = mid1+(end-start)/3;
		
		if(start<end) {
			if(arr[mid1] == key)
				return mid1;
			
			if(arr[mid2] == key)
				return mid2;
			
			// If key is present in right one-third
			if(arr[mid1]>key)
				return ternarySearch(arr, start, mid1-1, key);
			
			// If x is present in middle one-third
			if(arr[mid1]<key && key <arr[mid2])
				return ternarySearch(arr, mid1+1, mid2-1, key);
			else 
				return ternarySearch(arr, mid2+1, end, key);
				
		}
		
		return -1;
	}
	
	private static int ternarySearch(int[] arr, int key) {
		int start =0, end = arr.length-1;
		
		while(start<=end) {
			int mid1 = start+(end-start)/3;
			int mid2 = mid1+(end-start)/3;
			
			if(arr[mid1] == key)
				return mid1;
			
			if(arr[mid2] == key)
				return mid2;
			
			if(arr[mid2] < key)
				start = mid2+1;
			
			else if(arr[mid1]> key)
				end = mid1-1;
			else {
				start = mid1+1;
				end   = mid2-1;
			}
		}
		
		return -1;
	}

}
