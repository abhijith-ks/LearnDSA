package io.abhijith.challenges.dp;

/**
 * Given coins of certain denominations and a total, how many ways these coins can be combined to get the total.
 */

public class CoinChangeWays {

    public void findSolution() {

        int[] coins = {1, 2, 3};
        int total = 5;

        int[][] dp = new int[coins.length + 1][total + 1];

        for(int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < total + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < total + 1; j++) {
                if(coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[coins.length][total]);
    }

}
