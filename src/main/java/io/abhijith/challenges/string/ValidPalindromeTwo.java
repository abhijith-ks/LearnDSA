package io.abhijith.challenges.string;

/**
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome
 * 
 * @author abhijith-ks
 */

public class ValidPalindromeTwo {
	
	String word = "abca";
	
	public boolean isPalindrome(int i, int j) {
		while( i < j) {
			if(word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++; j--;
		}
		
		return true;
	}

	public void findSolution() {
		
		int i = 0, j = word.length() - 1;
		boolean flag = false;
		
		while(i < j) { 
			if(word.charAt(i) != word.charAt(j)) {
				
				flag = isPalindrome(i + 1, j) || isPalindrome(i, j -1);
				break;
				
			}
			i++; j--;
		}
		
		System.out.println(flag);
		
		
//		Another method
//		
//		while(i < j) {
//			
//			if(word.charAt(i) != word.charAt(j)) {
//				
//				if(flag == true) {
//					System.out.println("Not a valid palindrome");
//					return;
//				}
//				
//				flag = true;
//				if(word.charAt(i + 1) == word.charAt(j)) {
//					i++;
//				} else if(word.charAt(i) == word.charAt(j - 1)) {
//					j--;
//				} else {
//					System.out.println("Not a valid palindrome");
//					return;
//				}
//			}
//			i++; j--;
//			
//		}
//		System.out.println("Valid Palindrome");
		
	}

}
