package io.abhijith.challenges.dp;

/**
 * Given n which is total number of keys in BST, how many BSTs can be formed with n keys
 *
 * https://www.youtube.com/watch?v=YDf982Lb84o&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=34
 */

public class CountNumberOfBSTForNKeys {

    public void findSolution() {
        int n = 5;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);
    }

}
