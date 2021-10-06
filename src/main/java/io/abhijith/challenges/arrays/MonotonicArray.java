package io.abhijith.challenges.arrays;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i<=j, A[i] <= A[j]
 * An array A is monotone decreasing if for all i<=j, A[i] >= A[j]
 * 
 * @author abhijith-ks
 */

public class MonotonicArray {
	
	public void findSolution(int[] nums) {
		
		boolean increasing = true;
		boolean decreasing = true;
		
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1]) {
				increasing = false;
			}
			if(nums[i] < nums[ i + 1]) {
				decreasing = false;
			}
		}
		
		if(increasing || decreasing) {
			System.out.println("Monotonic array");
		} else {
			System.out.println("Not a monotonic array");
		}
		
	}

}
