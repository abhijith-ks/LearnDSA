package io.abhijith.challenges.string;

/**
 * Given String, find the first non-repeating character with the position
 * 
 * @author abhijith-ks 
 */

import java.util.HashMap;

public class FirstUniqueCharacter {

	public void findSolution(String s) {
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		for(int i=0; i < s.length(); i++) {
			if(hmap.containsKey(s.charAt(i))) {
				hmap.replace(s.charAt(i), hmap.get(s.charAt(i)) + 1);
			} else {
				hmap.put(s.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(hmap.get(s.charAt(i)) == 1) {
				System.out.println("First unique character is " + s.charAt(i) + " at position " + i);
				return;
			}
		}
		
		System.out.println("There is  no non-repeating characters" );
		
	}
	
}
