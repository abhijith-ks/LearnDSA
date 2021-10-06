package io.abhijith.challenges.string;

/**
 * Find the first recurring character in the given string
 * @author abhijith-ks
 */

import java.util.HashMap;

public class FirstRecurringCharacter {
	
	public void findSolution(String str) {
		HashMap<Character, Integer> hmap = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(hmap.get(str.charAt(i)) != null) {
				System.out.println(str.charAt(i));
				return;
			}
			hmap.put(str.charAt(i), 1);
		}
		System.out.println("None");
	}

}
