package io.abhijith.challenges.search_and_sort;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	
	String s = "tree";
	
	public void findSolution() {
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		for(char c: s.toCharArray()) {
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a,b) -> hmap.get(b) - hmap.get(a) );
		
		maxHeap.addAll(hmap.keySet());
		
		StringBuilder str = new StringBuilder();
		
		while(!maxHeap.isEmpty()) {
			char c = maxHeap.remove();
			for(int i = 0; i < hmap.get(c); i++) {
				str.append(c);
			}
		}
		
		System.out.println(str);
		
	}

}
