package io.abhijith.challenges.arrays;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
	
	int[] candidates = new int[] {10,1,2,7,6,1,5};
	int target = 8;

	public void findSolution() {
	

		List<List<Integer>> result  = new ArrayList<>();
		Arrays.sort(candidates);
		
		findCombinations(0, target, new ArrayList<Integer>(), result);
		
		for(List<Integer> l: result) {
			System.out.println(l);
		}
		
	}
	
	public void findCombinations(int index, int target, List<Integer> current, List<List<Integer>> result) {
		
		if(target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		if(target < 0) {
			return;
		}
		
		for(int i = index; i < candidates.length; i++) {
			if(index == i || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				findCombinations(i + 1, target - candidates[i], current, result);
				current.remove(current.size() - 1);
			}
		}
		
	}
	
}
