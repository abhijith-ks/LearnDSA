package io.abhijith.challenges.dp;

/**
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2)
 *
 * Reference: https://www.youtube.com/watch?v=_nCsPn7_OgI&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=9
 */

public class LongestPalindromicSubsequence {

    public void findSolution() {

        String s1 = "agbdba";
        int length =  s1.length();

        int[][] dp = new int[length][length];

        for(int i = 0; i < s1.length(); i++) {
            dp[i][i] = 1;
        }

        for(int l = 2; l <= length; l++) {
            for(int i = 0; i < length - l + 1; i++) {
                int j = l + i - 1;
                if(l == 2 && s1.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = 2;
                } else if(s1.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        System.out.println("Maximum length of palindrome sequence : " + dp[0][s1.length() - 1]);

    }

}
