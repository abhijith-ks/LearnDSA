package io.abhijith.challenges.problems;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters is just like a telephone buttons. 1 does not map to any letters
 * 
 * Example: "23" -> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 
 * @author abhijith-ks
 */

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationPhoneNumber {
	
	public void findSolution(String digits) {
		List<String> result = new ArrayList<>();
		if(digits.length() == 0 || digits == null) {
			System.out.println("Empty digits");
		}
		String mapping[] = {
			"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
		};
		
		letterCombinations(result, digits, "", 0, mapping);
		System.out.println(result);
	}
	
	public void letterCombinations(List<String> result, String digits, String current, int index, String[] mapping) {
		
		if(digits.length() == index) {
			result.add(current);
			return;
		}
		
		String letters = mapping[digits.charAt(index) - '0'];
		for(int i = 0; i < letters.length(); i++) {
			letterCombinations(result, digits, current + letters.charAt(i), index + 1, mapping);
		}
		
	}

}
