package io.abhijith.challenges.dp;

/**
 * Given a 2 dimensional matrix,
 * find minimum cost path to reach bottom right from top left provided you can only from down and right.
 */

public class MinimumCostPath {

    public void findSolution() {

        int[][] matrix = {
                {1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}
        };
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 1; i < m; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }

        for(int i = 1; i < n; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        System.out.println(matrix[m - 1][n - 1]);

    }

}
