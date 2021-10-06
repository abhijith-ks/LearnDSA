package io.abhijith.challenges.arrays;

/**
 * Given an array, find whether it contains duplicate elements
 * 
 * @author abhijith-ks
 */

import java.util.HashSet;

public class ContainsDuplicate {
	
	public void findSolution(int[] a) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < a.length; i++) {
			if(set.contains(a[i])) {
				System.out.println("Arrays contains duplicate");
				return;
			} else {
				set.add(a[i]);
			}
		}
		System.out.println("Arrays does not contains duplicate");
		
	}

}
