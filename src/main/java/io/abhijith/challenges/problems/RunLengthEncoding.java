package io.abhijith.challenges.problems;

/**
 * Implement Run-length encoding
 * 
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive character as a single count and character.
 * Example: String "AAAABBBCCDAA" would be encoded as 4A3B2C1D2A
 * 
 * @author abhijith-ks
 *
 */

public class RunLengthEncoding {

	public void findSolution(String input) {
		
		String result = "";
		char prev = input.charAt(0);
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			if(x == prev) {
				count++;
			} else {
				result += "" + count + "" + prev;
				prev = input.charAt(i);
				count = 0;
				i--;
			}
		}
		result += "" + count + "" + prev; 
		
		System.out.println(result);
	}
	
}
