package io.abhijith.challenges.dp;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Dynamic Programming
 * 
 * @author abhijith-ks
 */

public class CoinChangeProblem {
	
	
	int[] coins = new int[] {2,5,6,8};
	int key = 11;
	
	public void findSolution() {
		
		int[] arr = new int[key + 1];
		int[] values = new int[key + 1];
		arr[0] = 0;
		
		for(int i = 1; i <= key; i++) {
			arr[i] = key + 1;
			values[i] = -1;
		}
		
		for(int i = 1; i <= key; i++) {
			for(int j = 0; j < coins.length; j++) {
				int min = arr[i];
				if(i < coins[j]) {
					continue;
				}
				
				int temp = arr[i - coins[j]] + 1;
				if(temp < arr[i]) {
					arr[i] = temp;
					values[i] = j;
				}
			}
		}
		
		if(values[values.length - 1] == -1) {
			System.out.println("Not possible to add up to sum");
		} else {
			System.out.println(arr[key]);
		}
//		anotherSolution();
		
	}

	public void anotherSolution() {
		int[][] dpMatrix = new int[coins.length][key + 1];
		for(int i = 0; i < coins.length; i++) {
			dpMatrix[i][0] = 0;
		}

		for(int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= key; j++) {
				if(j/coins[i] > 0) {
					if(i > 0) {
						dpMatrix[i][j] = Math.min(dpMatrix[i - 1][j], dpMatrix[i][j - coins[i]] + 1);
					} else {
						dpMatrix[i][j] = j/coins[i];
					}
				} else {
					if(i > 0) {
						dpMatrix[i][j] = dpMatrix[i - 1][j];
					} else {
						dpMatrix[i][j] = 0;
					}
				}
			}
		}

		System.out.println(dpMatrix[coins.length - 1][key]);
	}

}
