package io.abhijith.challenges.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings
 * 
 * @author abhijith-ks
 */

public class LongestCommonPrefix {

	String[] strs = new String[] {"flower", "flow", "flight"};
	
	public void findSolution() {
		
		String longestPrefix = "";
		
		if(strs == null || strs.length == 0) {
			System.out.println(longestPrefix);
		}
		
		for(int j = 0; j < strs[0].length(); j++) {
			boolean flag = false;
			for(int i = 0; i < strs.length; i++) {
				if(strs[i].length() < j) {
					flag = true;
					break;
				}
				if(strs[i].charAt(j) != strs[0].charAt(j)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			} else {
				longestPrefix += strs[0].charAt(j);
			}
		}
		
		System.out.println("Result : " + longestPrefix);
		
	}
	
}
