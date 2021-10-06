package io.abhijith.challenges.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * @author abhijith-ks
 */

public class ValidPalindromeAlphanumeric {
	
	public void findSolution(String s) {

		int index = s.length() - 1;
		
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isLetterOrDigit(s.charAt(i))) {
				continue;
			}
			if(!Character.isLetterOrDigit(s.charAt(index))) {
				index--;
				i--;
				continue;
			}
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(index))) {
				System.out.println(false);
				return;
			}
			index--;
		}
		
		System.out.println(true);
		
	}

}
