package io.abhijith.challenges.arrays;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than [ n/2 ]  times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class MajorityElement {
	
	public void findSolution(int a[]) {
		
		if(a.length == 1) {
			System.out.println(a[0]);
			return;
		}
				
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			if(hmap.containsKey(a[i])) {
				hmap.replace(a[i], hmap.get(a[i])+1);
				if(hmap.get(a[i]) > a.length/2) {
					System.out.println(a[i]);
					return;
				}
			} else {
				hmap.put(a[i],1);
			}
		}
		
	}

}
