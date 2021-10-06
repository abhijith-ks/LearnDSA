package io.abhijith.challenges.string;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */

public class LongestCommonSubstring {

    public void findSolution() {

        String x = "OldSite:GeeksforGeeks.org";
        String y = "NewSite:GeeksQuiz.com";

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for(int i = 0; i <= x.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= y.length(); j++) {
            dp[0][j] = 0;
        }

        int result = 0;

        for(int i = 1; i <= x.length(); i++) {
            for(int j = 1; j <= y.length(); j++) {
                if(x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(dp[i][j], result);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(result);

    }

}
