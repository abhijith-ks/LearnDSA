package io.abhijith.challenges.problems;

/**
 * You are given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have. Find how many of the stones you have are also jewels.
 * 
 * Letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive.
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class JewelsAndStones {

//	"aA", "aAAbbbb"
	public void findSolution(String j, String s) {
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}
		
		int count = 0;
		for(int i = 0; i < j.length(); i++) {
			count += hmap.getOrDefault(j.charAt(i), 0);
		}
		
		System.out.println(count);
		
	}

}
