package io.abhijith.challenges.arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 * 
 * @author abhijith-ks
 */

public class RemoveDuplicateSortedArray {
	
	public void findSolution(int[] nums) {
		
		int index = 1;
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] != nums[i+1])
				nums[index++] = nums[i+1];
		}
		
		for(int j = 0; j < index; j++) {
			System.out.println(nums[j]);
		}
		
//		int pointer = 1, i = 0, hold = 0;
//		while(pointer < nums.length) {
//			if(nums[hold] != nums[pointer]) {
//				i++;
//				nums[i] = nums[pointer];
//				hold = pointer;
//			}
//			pointer++;
//		}
//		
//		for(int j = 0; j <= i; j++) {
//			System.out.println(nums[j]);
//		}
	}

}
