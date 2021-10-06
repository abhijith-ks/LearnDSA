package io.abhijith.challenges.problems;

/**
 * Given an array for which the i-th element is the price of a given stock in i-th day
 * Design an algorithm to get the maximum profit 
 * You are allowed to do only one each transaction for buy and sell
 * 
 * Example: {7,1,5,3,6,4}
 * 6 - 1 = 5
 * 
 * @author abhijith-ks
 *
 */

public class BuySellStock {

	public void findSolution(int a[]) {
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
			}
			else {
				max = Math.max(max, a[i] - min);
			}
		}
		
		System.out.println(max);
		
	}
	
}
