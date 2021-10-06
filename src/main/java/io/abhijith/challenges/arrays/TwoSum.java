package io.abhijith.challenges.arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].

 * @author abhijith-ks
 *
 */

import java.util.HashMap;

public class TwoSum {
	
	public void findSolution(int[] nums, int target) {
		
		int[] index = new int[2];
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i=0 ; i<nums.length; i++) {
			int temp = target - nums[i];
			if(hmap.containsKey(temp)) {
				index[0] = hmap.get(temp);
				index[1] = i;
				System.out.println("[" + index[0] + "," + index[1] + "]");
				return;
			} 
			hmap.put(nums[i], i);
		}
		
	}
	
	
	public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(i == j){
                    continue;
                }
                if(nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
        
    }

}
