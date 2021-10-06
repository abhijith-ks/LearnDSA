package io.abhijith.challenges.arrays;

/**
 * Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once
 * Find all the elements of [1,n] inclusive that do not appear in this array.
 * 
 * Do it without extra space and in O(n) runtime
 * 
 * @author abhijith-ks
 *
 */

public class DisappearedNumbersArray {
	
	public void findSolution(int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
			
			int x = Math.abs(nums[i]);
			if((nums[x - 1]) > 0) 
				nums[x-1] *= -1;
			
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				System.out.print((i+1) + " ");
			}
		}
		
	}

}
