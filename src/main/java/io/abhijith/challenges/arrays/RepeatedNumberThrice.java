package io.abhijith.challenges.arrays;

/**
 * Given a non-empty array of integers, every element appears three times except one, which appears only once
 * Find that integers
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class RepeatedNumberThrice {
	
	public void findSolution(int a[]) {
		
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			if(hmap.containsKey(a[i])) {
				hmap.put(a[i], hmap.get(a[i]) + 1);
			} else {
				hmap.put(a[i], 1);
			}
		}

		for(int i: hmap.keySet()) {
			if(hmap.get(i) != 3) {
				System.out.println(i);
			}
		}
		
		
//		Better and efficient method
		System.out.println("\nSecond Method\n");
		int one = 0;
		int two = 0;
		for(int i = 0; i < a.length; i++) {
			one = (one ^ a[i]) & ~two;
			two = (two ^ a[i]) & ~one;
		}
		System.out.println(one);
	}

}
