package com.tarang.dsdaa.searching;

import java.util.Scanner;
import java.util.stream.Stream;

/*
 * provided sorted array
 * reduced tie complexity to O(Log n)
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		System.out.println("Enter numbers :");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Enter key to search ");
		int key = sc.nextInt();
		
		System.out.println("Array "+line+" Key is "+key);
		
		int[] arr = Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int response = binarySearch(arr, 0, arr.length-1, key);
		
		if(response != -1)
			System.out.println("Key found at "+response);
		else 
			System.out.println("Key does not found");

	}

	private static int binarySearch(int[] arr,int start, int end, int key) {
		
		int mid = start+(end-start)/2;
		
		if(start<end) {
			if(arr[mid] == key)
				return mid;
			if(arr[mid]<key)
				return binarySearch(arr, mid+1, end, key);
			else 
				return binarySearch(arr, start, mid-1, key);
				
		}
		
		
		return -1;
	}
	
	private static int binarySearch(int[] arr, int key) {
		int start =0, end = arr.length-1;
		
		while(start<=end) {
			int mid = start+(end-start)/2;
			
			if(arr[mid] == key)
				return mid;
			if(arr[mid] < key)
				start = mid+1;
			else 
				end = mid=1;
		}
		
		return -1;
	}

}
