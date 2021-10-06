package io.abhijith.challenges.problems;

/**
 * Given a positive integer, check whether it has alternating bits
 * ie, two adjacent bits will always have different values
 * 
 * @author abhijith-ks
 */

public class AlternatingBits {
	
	public void findSolution(int num) {

		int prev = num % 2;
		num /= 2;
		while(num != 0) {
			int temp = num % 2;
			
			if(temp == prev) {
				System.out.println(false);
				return;
			}
			
			prev = temp;
			num /= 2;
		}
		System.out.println(true);
		
	}

}
