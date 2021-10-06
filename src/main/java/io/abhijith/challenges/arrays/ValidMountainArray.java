package io.abhijith.challenges.arrays;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * 
 * Recall that A is a mountain array if and only if:
 * - A.length >= 3
 * - There exists some i with 0 < i < A.length - 1 such that:
 *   - A[0] < A[1] < ... < A[i-1] < A[i]
 *   - A[i] > A[i+1] > ... > A[A.length - 1]
 *   
 * @author abhijith-ks
 */

public class ValidMountainArray {

	int[] nums = new int[] {0,3,2,1};
	
	public void findSolution() {
		
		if(nums.length < 3) {
			System.out.println("Not a valid mountain array");
		}
		
		int i;
		for(i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				System.out.println("Not a valid mountain array");
				return;
			}
			else if(nums[i] < nums[i-1]) {
				break;
			}
		}
		
		if(i == nums.length || i == 1) {
			System.out.println("Not a valid mountain array");
			return;
		}
		
		for(int j = i; j < nums.length; j++) {
			if(nums[j] >= nums[j-1]) {
				System.out.println("Not a valid mountain array");
				return;
			}
		}
		
		
		
		System.out.println("Valid mountain array");
		
	}
	
}
