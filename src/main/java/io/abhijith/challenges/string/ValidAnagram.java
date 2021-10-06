package io.abhijith.challenges.string;

/**
 * Given two strings s and  t, write a function to determine whether t is an anagram of s
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class ValidAnagram {
	
	public void findSolutionBetter(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			System.out.println("Not a valid anagram");
			return;
		}
		
		int[] counts = new int[25];
		
		for(int i = 0; i < s1.length(); i++) {
			counts[s1.charAt(i) - 'a']++;
			counts[s2.charAt(i) - 'a']--;
		}
		
		for(int i : counts) {
			if(i != 0) {
				System.out.println("Not a valid anagram");
				return;
			}
		}
		
		System.out.println("Valid anagram");
		return;
		
	}

	
	
	public void findSolution(String s1, String s2) {
		
		// Trigger for a better solution
		findSolutionBetter(s1, s2);
		
		if(s1.length() != s2.length()) {
			System.out.println("Not a valid anagram");
			return; 
		}
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < s1.length(); i++) {
			if(hmap.get(s1.charAt(i)) != null) {
				hmap.replace(s1.charAt(i), hmap.get(s1.charAt(i)) + 1);
			} else {
				hmap.put(s1.charAt(i), 1);
			}
		}
		
		HashMap<Character, Integer> hmap1 = new HashMap<>();
		
		for(int i = 0; i < s2.length(); i++) {
			if(hmap1.get(s2.charAt(i)) != null) {
				hmap1.replace(s2.charAt(i), hmap1.get(s2.charAt(i)) + 1);
			} else {
				hmap1.put(s2.charAt(i), 1);
			}
		}
		
		if(hmap.size() != hmap1.size()) {
			System.out.println("Not a valid anagram");
			return;
		}
		
		for(Character ch : hmap.keySet()) {
			if(hmap.get(ch) != hmap1.get(ch)) {
				System.out.println("Not a valid anagram");
				return;
			}
		}
		
		System.out.println("Valid Anagram");
	}
	
}
