package io.abhijith.challenges.string;

/**
 * Implement an auto-complete system.
 * That is given a query string and s and a set of all possible query strings
 * Return all strings in the set that have s as a prefix
 * 
 * Example: Given the query string 'de' and a set os strings ["dog","dear","deal","disc","drum","demon"]
 * return ['dear', 'deal', 'demon']
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;

public class AutoCompleteSystem {
	
	private String[] dict = new String[] {"dog","dear","deal","disc","drum","demon"};
	
	public void findSolution(String pre) {
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<dict.length; i++) {
			if(dict[i].substring(0, pre.length()).equals(pre)) {
				list.add(dict[i]);
			}
		}
		System.out.println(list);
	}
	
}
