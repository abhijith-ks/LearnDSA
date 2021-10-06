package io.abhijith.challenges.problems;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines.
 * Write a function that will return true if the ransom note can be constructed from the magazines.
 * Otherwise return false
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class RansomeNote {
	
	String magazine = "aab";
	String ransome = "aa";
	
	public void findSolution() {
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		for(char c: magazine.toCharArray()) {
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}
		
		for(char c: ransome.toCharArray()) {
			if(hmap.get(c) > 0) {
				hmap.put(c, hmap.get(c) - 1);
			}
			else {
				System.out.println(false);
				return;
			}
		}
		
		System.out.println(true);
		
	}

}
