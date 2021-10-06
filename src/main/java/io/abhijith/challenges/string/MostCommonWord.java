package io.abhijith.challenges.string;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lower case, and free of punctuation.
 * Words in he paragraph are not case sensitive. The answer is in lower case.
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
	
	String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
	
	public void findSolution(String[] banned) {
		
		HashSet<String> set  = new HashSet<String>();
		set.addAll(Arrays.asList(banned));

		HashMap<String, Integer> hmap = new HashMap<>();
		for(String word: paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
			if(!set.contains(word))
				hmap.put(word, hmap.getOrDefault(word, 0) + 1);
		}
		
		int temp = Integer.MIN_VALUE;
		String s = null;
		for(String text: hmap.keySet()) {
			if(hmap.get(text) > temp) {
				temp = hmap.get(text);
				s = text; 
			}
		}

		System.out.println(s);
	}

}
