package com.tarang.dsdaa.searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * provided uniform distribution(sorted) of elements
 *  complexity to O(log n), worst case O(n)
 */
public class ExponentialSearch {

	public static void main(String[] args) {
		
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Enter key to search ");
		int key = sc.nextInt();
		
		System.out.println("Array "+line+" Key is "+key);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int index = exponentialSearch(arr, arr.length, key );
		
		if(index != -1)
			System.out.println("Key found at "+index);
		else 
			System.out.println("Key does not found");

	}

	private static int exponentialSearch(int[] arr, int n, int key) {
		
		// If key is present at firt location itself
        if (arr[0] == key)
            return 0;
		
        // Find range for binary search by repeated doubling
        int i=1;
        while(i<n && arr[i]<= key) {
        	i = i*2;
        }
        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i/2, Math.min(i, n-1), key);

	}

}
