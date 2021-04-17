package com.tarang.dsdaa.searching;

import java.util.Scanner;
import java.util.stream.Stream;

public class LinearSearch {
	
	static int linearSearch(String[] arr, int key){
		
		int[] intArr = Stream.of(arr).mapToInt(Integer::parseInt).toArray();
		for(int i=0;i<arr.length;i++) {
			if(intArr[i] == key)
				return i;
				
		}
		return -1;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter numbers ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] arr = line.split(" ");
		
		System.out.println("Enter key you want to search :");
		int key = sc.nextInt();
		
		System.out.println("Array is :"+line +" Key "+key );
		
		int response = linearSearch(arr, key);
		
		System.out.println("Key found at "+response);
		
	}

}
