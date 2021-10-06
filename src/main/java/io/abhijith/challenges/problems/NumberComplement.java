package io.abhijith.challenges.problems;

/**
 * Given a positive integer, output its complement number.
 * The complement number strategy is to flip the bits of its binary representation.
 * 
 * @author abhijith-ks
 *
 */

public class NumberComplement {
	
	public void findSolution(int num) {
		
		int result = 0;
		int p = 0;
		
		while(num > 0) {
			
			if( (num % 2) == 0) {
				result += 1 * Math.pow(2, p);
			}
			p++;
			num /= 2;
		}
		
		System.out.println(result);
	}

}
