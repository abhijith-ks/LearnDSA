package io.abhijith.challenges.arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * 
 * @author abhijith-ks
 */

public class SortArrayByParity {
	
	int[] nums = new int[] {3,1,4,2};
	
	public void findSolution() {
		
		int i = 0, j = nums.length - 1;
		
		while(i < j) {
			if(nums[i] % 2 != 0 && nums[j] % 2 == 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			} else {
				if(nums[i] % 2 == 0) {
					i++;
				}
				if(nums[j] % 2 != 0) {
					j--;
				}
				
			}
			
		}
		
		for(int k = 0; k < nums.length; k++) {
			System.out.print(nums[k] + " ");
		}

	}

}
