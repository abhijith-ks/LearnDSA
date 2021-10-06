package io.abhijith.challenges.problems;

/**
 * Given a string, judge whether the use of the Capitals in the word is correct or not
 * Valid uses: USA, leetcode, Google 
 * 
 * @author abhijith-ks
 */

public class DetectCapital {

	String s = "Google";
	
	public void findSolution() {
		
		int capitalCount = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)))
					capitalCount++;
		}
		
		if(capitalCount == s.length() || capitalCount == 0 || (capitalCount == 1 && Character.isUpperCase(s.charAt(0)))) {
			System.out.println("Valid");
		} else {
			System.out.println("Not Valid");
		}
		
	}

}
