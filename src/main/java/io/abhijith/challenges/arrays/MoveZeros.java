package io.abhijith.challenges.arrays;

/**
 * Given an array of integers
 * Move the zeroes to the end of the array while maintaining the relative order of non-zero integers
 * 
 * Linear time complexity
 * Do not make a copy of the array
 * 
 * @author abhijith-ks
 *
 */

public class MoveZeros {
	
	public void findSolution(int[] nums) {
		
		int index = 0;
		for(int i=0; i <  nums.length; i++) {
			if(nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}
		
		for(int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		for(int i :  nums) {
			System.out.println(i);
		}
		
	}
	
}
