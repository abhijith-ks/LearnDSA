package io.abhijith.challenges.problems;

/**
 * Given a set of distinct integers
 * Return all subsets (power set)
 * Solution must not contain duplicates
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	int[] arr = new int[] {1,2,3};

	public void findSolution() {
		
		List<List<Integer>> result = new ArrayList<>();
		findSubset(0, new ArrayList<Integer>(), result);
		
		for(List<Integer> l : result) {
			System.out.println(l);
		}
		
	}
	
	public void findSubset(int index, List<Integer> current, List<List<Integer>> result) {
		
		result.add(new ArrayList<>(current));
		for(int i = index; i < arr.length; i++) {
			current.add(arr[i]);
			findSubset(i + 1, current, result);
			current.remove(current.size() - 1);
		}
		
	}
	
}
