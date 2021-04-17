package com.tarang.dsdaa.searching;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * for sorted array
 * time complexity O(√n)
 * The time complexity of Jump Search is between Linear Search (( O(n)) and Binary Search (O(Log n)).
 * Binary Search is better than Jump Search, but Jump search has an advantage that we traverse back only once 
 * (Binary Search may require up to O(Log n) jumps, consider a situation where the element to be searched is the smallest element or smaller than the smallest). So in a system where binary search is costly, we use Jump Search.
 */
public class JumpSearch {

	public static void main(String[] args) {
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Enter key to search ");
		int key = sc.nextInt();
		
		System.out.println("Array "+line+" Key is "+key);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int response = jumpSearch(arr, arr.length, key);
		
		if(response != -1)
			System.out.println("Key found at "+response);
		else 
			System.out.println("Key does not found");
	}

	private static int jumpSearch(int[] arr, int n, int key) {
		
		//1 2 3 4 5 6 7 8 9    Key 7
		// Finding block size to be jumped 
		int step = (int) Math.floor(Math.sqrt(n));
		
	    // Finding the block where element is present (if it is present) 
		int prev = 0;
		while(arr[Math.min(step, n)-1] < key) {
			prev = step;
			step += (int) Math.floor(Math.sqrt(n));
			if(prev >= n)
				return -1;
		}
		
		// Doing a linear search for x in block beginning with prev. 
		while(arr[prev]< key) {
			prev++;
			
//			if(prev == Math.min(step, n))
//				return -1;
		}
		
		if(arr[prev] == key)
			return prev;
		
		return -1;
	}

}
