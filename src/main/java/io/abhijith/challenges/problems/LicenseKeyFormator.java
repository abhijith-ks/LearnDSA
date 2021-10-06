package io.abhijith.challenges.problems;

/**
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, 
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lower-case letters should be converted to upper-case.
 * 
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * 
 * @author abhijith-ks
 */

public class LicenseKeyFormator {
	
//	String s = "5F3Z-2e-9-W";
//	int k = 4;
	
	String s = "2-5g-3-J";
	int k = 2;
	
	public void findSolution() {
		
		StringBuilder sb1 = new StringBuilder();
		int index = s.length() - 1;
		int count = k;
		
		while(index >= 0) {
			
			char temp = Character.toUpperCase(s.charAt(index));
			
			if(Character.isDigit(temp) || Character.isLetter(temp)) {
				if(count > 0) {
					sb1.insert(0, temp);
					count--;
				} else {
					sb1.insert(0, '-');
					index++;
					count = k;
				}
			}
			index--;
		}
		System.out.println(sb1);
		
	}

}
