package io.abhijith.challenges.dp;

/**
 * Implement wildcard pattern matching with support for '?' and '*'
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 */

public class WildCardMatching {

    public void findSolution() {

        String pattern = "x?y*z";
        String input = "xaylmz";
        int m = input.length();
        int n = pattern.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i < n + 1; i++) {
            if(pattern.charAt(i - 1) == '*') { // * comes before any characters, then the value is true
                boolean flag = false;
                int j = i - 2;
                while(j >= 0) {
                    if(pattern.charAt(j) != '*') {
                        flag = true;
                        break;
                    }
                    j--;
                }
                if(!flag) {
                    dp[0][i] = true;
                } else {
                    dp[0][i] = false;
                }
            } else {
                dp[0][i] = false;
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        System.out.println(dp[m][n]);

        System.out.println();

        for(int i = 0; i < m + 1; i++) {
        	for(int j = 0; j < n + 1; j++) {
                System.out.print("\t" + dp[i][j]);
        	}
            System.out.println();
        }
    }

}
