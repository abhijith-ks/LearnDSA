package io.abhijith.challenges.string;

/**
 * A string s of lower-case letters is given.
 * We want to partition this string into as many parts as possible so that each letters appears in at most one part,
 * return a list of integers representing the size of these parts
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	String s = "ababcbacadefegdehijhklijz";
	
	public void findSolution() {
		
		List<Integer> partitionLengths = new ArrayList<>();
		int[] lastIndex = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		for(int i = 0; i < lastIndex.length; i++) {
			System.out.print("\t" + lastIndex[i]);
		}
		System.out.println();
		int i = 0;
		while( i < s.length() ) {
			int end = lastIndex[s.charAt(i) - 'a'];
			int j = i;
			while(j != end) {
				end = Math.max(end, lastIndex[s.charAt(j++) - 'a']);
			}
			partitionLengths.add(j - i + 1);
			i = j+1;
		}
		
		System.out.println(partitionLengths);
		
	}

}
