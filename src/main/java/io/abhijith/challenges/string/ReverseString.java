package io.abhijith.challenges.string;

/**
 * Program to reverse a string
 * 
 * @author abhijith-ks
 *
 */

public class ReverseString {
	
	public void findSolution(String s) {
		
		char[] characters = s.toCharArray();
		
		int j = s.length()-1;
		char temp;
		for(int i=0; i < j; i++, j--) {
			temp = characters[i];
			characters[i] = characters[j];
			characters[j] = temp;
		}
		
		String str = String.valueOf(characters); 
		System.out.println(str);
		
	}

}
