package io.abhijith.challenges.amazon;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {

    public void findSolution() {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        if(grid == null || grid.length == 0)
            return;

        int m = grid.length, n = grid[0].length;
        int[][] dpMatrix = new int[m][n];

        dpMatrix[0][0] = grid[0][0];

        for(int i = 1; i < m; i++) {
            dpMatrix[i][0] = dpMatrix[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++) {
            dpMatrix[0][i] = dpMatrix[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        	    int val = grid[i][j];
                dpMatrix[i][j] = Math.min(dpMatrix[i][j - 1] + val, dpMatrix[i - 1][j] + val);
        	}
        }

        System.out.println(dpMatrix[m - 1][n - 1]);
    }

}
