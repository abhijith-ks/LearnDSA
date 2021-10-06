package io.abhijith.challenges.graph;

/**
 * A robot is located at the top-left corner of a m*n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * 
 * How many possible unique paths are there
 * 
 * @author abhijith-ks
 */

public class UniquePaths {
	
	public void findSolution() {
		
		int m = 3, n = 3;
		
		int dp[][] = new int[m][n];
		
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		
		System.out.println(dp[m - 1][n - 1]);
	}

}
