package io.abhijith.challenges.arrays;

/**
 * Given a non-empty array containing only positive integers.
 * Find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionEqualSubsetSum {

	int[] nums = new int[] {1, 5, 11, 5, 7, 3};
	List<List<Integer>> returnVal = new ArrayList<>();
	
	public void findSolution() {
		
		int sum = 0;
		for(int i: nums) {
			sum += i;
		}
		
		if(sum % 2 != 0 ) {
			System.out.println(false);
			return;
		}
		
		System.out.println(findPartition(0, 0, sum));
		System.out.println(findPartitionDP(0, 0, sum, new HashMap<String, Boolean>()));
		
	}
	
	
	public boolean findPartition(int index, int sum, int total) {
		
		if(sum * 2 == total) {
			return true;
		}
		
		if(sum > total/2 || index >= nums.length) {
			return false;
		}
		
		return findPartition(index + 1, sum, total) || findPartition(index + 1, sum + nums[index], total);
	}
	
	
//	Solution with Dynamic Programming
	public boolean findPartitionDP(int index, int sum, int total, HashMap<String, Boolean> status) {
		String s = index + "" + sum;
		if(status.containsKey(s)) {
			return status.get(s);
		}
		
		if(sum * 2 == total) {
			status.put(s, true);
			return true;
		}
		
		if(sum > total/2 || index >= nums.length) {
			status.put(s, false);
			return false;
		}
		
		return findPartitionDP(index + 1, sum, total, status) || findPartitionDP(index + 1, sum + nums[index], total, status);
	}
	
}
