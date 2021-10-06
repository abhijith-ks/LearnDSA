package io.abhijith.challenges.problems;

/**
 * Calculate the power to n for a given number
 * 
 * @author abhijith-ks
 */

public class CalculatePowerRecursion {
	
	public void findSolution() {
		
		System.out.println(power(3,3));
		
	}
	
	public int power(int n, int i) {
		if(i == 0)
			return 1;
		return n * power(n, i-1);
	}

}
