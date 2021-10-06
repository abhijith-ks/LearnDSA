package io.abhijith.challenges.arrays;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array,
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class ContainsDuplicateAtmostDistance {
	
	public void findSolution(int nums[], int k) {
		
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(!hmap.containsKey(nums[i])) {
				hmap.put(nums[i], i);
			} else { 
				if(i - hmap.get(nums[i]) <= k) {
					System.out.println(true);
					return;
				}
				hmap.replace(nums[i], i);
			}
		}
		System.out.println(false);
		
//		Brute force solution
//		
//		for(int i = 0; i < nums.length; i++) {
//			
//			for(int j = i+1; j <= i + k; j++) {
//				if(j == nums.length) {
//					break;
//				}
//				if(nums[i] == nums[j]) {
//					System.out.println(true);
//					return;
//				}
//			}
//			
//		}
//		System.out.println(false);
		
	}

}
