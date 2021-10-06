package io.abhijith.challenges.problems;

/**
 * Given an array of integers, pick three numbers such that they contribute the maximum product possible
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class MaximumThreeNumberProduct {
	
	int[] arr = new int[] {-10, -10, 5, 2};
	
	public void findSolution() {
		
		Arrays.sort(arr);
		
		int max = Integer.MIN_VALUE;
		
		if(arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3] > max) {
			max = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
		}
		
		if(arr[1] < 0) {
			if(arr[0] * arr[1] * arr[arr.length - 1] > max) {
				max = arr[0] * arr[1] * arr[arr.length - 1];
			}
		}
		
		System.out.print(max);
		
	}

}
