package io.abhijith.challenges.dp;

/**
 * Given a matrix of 0s and 1s. Find biggest sub-square matrix entirely of 1s in this matrix.
 */

public class MaximumSubSquareMatrix {

    public void findSolution() {

        int[][] matrix = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        int maxVal = 0, maxIndexi = 0 , maxIndexj = 0;
        for(int i = 0; i < m + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                if(maxVal < dp[i][j]) {
                    maxVal = dp[i][j];
                    maxIndexi = i;
                    maxIndexj = j;
                }
            }
        }
        System.out.println(maxVal);
        System.out.println("Maximum end points : " + maxIndexi + " -- " + maxIndexj);
    }

}
