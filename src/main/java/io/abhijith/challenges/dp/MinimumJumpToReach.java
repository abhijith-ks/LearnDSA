package io.abhijith.challenges.dp;

import java.util.Arrays;

/**
 * Given an array, find minimum number to jumps to reach end of array,
 * given you can jump at max as much as value at position in array.
 */

public class MinimumJumpToReach {

    public void findSolution() {

        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int m = arr.length;

        int[] dp = new int[m];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < i; j++) {
                if(i - j <= arr[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        System.out.println(dp[m - 1]);
    }

}
