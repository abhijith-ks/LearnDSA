package io.abhijith.challenges.string;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *              
 * @author abhijith-ks
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	
	public void findSolution(String str) {
		int bigger = 0;
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		int n = str.length(), i = 0, j = 0;
		while(i < n && j < n) {
			if(!hmap.containsKey(str.charAt(j))) {
				hmap.put(str.charAt(j), j);
				j++;
				bigger = Math.max(bigger, j - i);
			}
			else {
				hmap.remove(str.charAt(i));
				i++;
			}
		}
		
// Different method		
//		for(int j=0;j<str.length();j++) {
//			count = 0;
//			for (int i=j; i<str.length(); i++) {
//				if(!hmap.containsKey(str.charAt(i))) {
//					count++;
//					hmap.put(str.charAt(i), i);
//				}
//				else {
//					hmap.clear();
//					break;
//				}
//			}
//			bigger = (bigger > count ) ? bigger : count;
//		}
		System.out.println(bigger);
		System.out.println(betterSolution(str));
	}

	public int betterSolution(String s1) {

		int length = s1.length();
		int[] lastIndex = new int[256];
		Arrays.fill(lastIndex, -1);

		int res = 0;
		int j = 0;
		for(int i = 0; i < length; i++) {

			j = Math.max(j, lastIndex[s1.charAt(i)] + 1);
			res = Math.max(i - j + 1, res);
			lastIndex[s1.charAt(i)] = i;
		}

		return res;
	}

}
