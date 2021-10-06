package io.abhijith.challenges.arrays;

/**
 * Given an array of integers, 
 * find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class FirstMissingPositiveInteger {
	
	public void findSolution(int[] a) {
		a = new int[] {1, 2, 0};
		int smallest = 1;
		
		Arrays.sort(a);
		for(int i=0; i < a.length; i++) {
			if(a[i] > 0) {
				if(i+1 < a.length) {
					if(a[i+1] > smallest+1) {
						smallest = smallest + 1;
						break;
					} else {
						smallest = a[i+1];
					}
				} 
				else {
					if(a[i] == smallest)
						smallest = a[i]+1;
				}
			}
		}
		System.out.println("Missing element : " + smallest);
	}

}
