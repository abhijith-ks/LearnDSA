package io.abhijith.challenges.string;

/**
 * Given two strings s1 and s2 which consist of only lower-case letters.
 * String s2 is generated by random shuffling string s1 and then add one more letter at a random position.
 * Find the letter that was added in s2.
 * 
 * @author abhijith-ks
 * 
 */

import java.util.HashMap;

public class FindAddedLetter {
	
	public void findSolution(String s1, String s2) {
		
		int sum = 0;
		
		for(int i = 0; i < s1.length(); i++) {
			sum += s2.charAt(i);
			sum -= s1.charAt(i);
		}
		
		sum += s2.charAt(s2.length() - 1);
		
		System.out.println((char)sum);
		
		
//		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
//		
//		for(int i = 0; i < s2.length(); i++) {
//			if(hmap.get(s2.charAt(i)) != null)					
//				hmap.put(s2.charAt(i), hmap.get(s2.charAt(i))+1);
//			else
//				hmap.put(s2.charAt(i), 1);
//		}
//		
//		for(int i = 0; i < s1.length(); i++) {
//			if(hmap.get(s1.charAt(i)) == null) {
//				System.out.println(hmap.get(s1.charAt(i)));
//				return;
//			} else {
//				hmap.put(s1.charAt(i), hmap.get(s1.charAt(i))-1);
//			}
//		}
//		
//		hmap.forEach((k, v) -> {
//			if(v != 0) {
//				System.out.println(k);
//				return;
//			}
//		});
		
	}

}
