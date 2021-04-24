package com.tarang.dsdaa.searching;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * provided uniform distribution(sorted) of elements
 *  complexity to O(log log n), worst case O(n)
 */
public class InterpolationSearch {

	public static void main(String[] args) {
		
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Enter key to search ");
		int key = sc.nextInt();
		
		System.out.println("Array "+line+" Key is "+key);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int index = interpolationSearch(arr, 0, arr.length-1, key );
		
		if(index != -1)
			System.out.println("Key found at "+index);
		else 
			System.out.println("Key does not found");

	}

	private static int interpolationSearch(int[] arr, int lo, int hi, int key) {
		
		
		// Probing the position with keeping
        // uniform distribution in mind.
		int pos;
		if(lo<=hi && key >= arr[lo] && key <= arr[hi]) {
			pos = lo + ( (key-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]) );
		
			//return index if key found
			if(arr[pos] == key)
				return pos;
			
			// If key is larger, key is in right sub array
			if(arr[pos] < key)
				return interpolationSearch(arr, pos+1, hi, key);
			
			if(arr[pos] > key)
				return interpolationSearch(arr, lo, pos-1, key);
		}
		
		return -1;
	}

}
