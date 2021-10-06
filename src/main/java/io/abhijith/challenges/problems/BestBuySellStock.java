package io.abhijith.challenges.problems;

/**
 * Given an array for which the i-th element is the price of a given stock on day i
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * You may not engage in multiple transactions at the same time
 * 
 * @author abhijith-ks
 *
 */

public class BestBuySellStock {
	
	public void findSolution(int[] stock) {
				
		int maxProfit = 0;
		
		for(int i = 0; i < stock.length - 1; i++) {
			if(stock[i + 1] > stock[i]) {
				maxProfit += stock[i + 1] - stock[i];
			}
		}
		
		System.out.println(maxProfit);
	}

}
