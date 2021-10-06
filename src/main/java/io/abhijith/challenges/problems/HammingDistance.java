package io.abhijith.challenges.problems;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the hamming distance.
 * 
 * @author abhijith-ks
 *
 */

public class HammingDistance {

	public void findSolution(int x, int y) {
		
		int val  = x ^ y;
		String s = Integer.toBinaryString(val);
		
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1')
				count++;
		}
		
		System.out.println(count);

		
//		Different approach
		int result = 0;
		while(x > 0 || y > 0) {
			result += (x % 2) ^ (y % 2);
			x >>= 1;
			y >>= 1;
		}
		System.out.println(result);
		
	}
	
}
