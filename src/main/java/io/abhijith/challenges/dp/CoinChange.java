package io.abhijith.challenges.dp;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1
 * 
 * Dynamic Programming and Recursive solution
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CoinChange {
	
	Integer[] coins = new Integer[] {1, 2, 5, 7};
	
	public void findSolution() {
		
		int amount = 11;
		
//		Dynamic Programming Solution
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for(int i = 0; i <= amount; i++) {
			for (Integer coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}
		
		if(dp[amount] <= amount) {
			System.out.println(dp[amount]);
		} else {
			System.out.println(-1);
		}
		
	
		
//		Recursive solution
		HashSet<Integer> set = new HashSet<>();
		
		Arrays.sort(coins, Collections.reverseOrder());
		
		getOptimumCoins(0, amount, set, 0);
		
		if(set.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(set);
		}
		
	}
	
	public void getOptimumCoins(int index, int sum, HashSet<Integer> set, int current) {
		
		if(sum == 0) {
			set.add(current);
			return;
		}
		
		if(sum < 0) {
			return;
		}
		
		for(int i = index; i < coins.length; i++) {
			int temp = sum / coins[i];
			current += temp;
			sum = sum - coins[i]*temp;
			
			getOptimumCoins(i + 1, sum, set, current);
		}
		
	}

}
