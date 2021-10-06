package io.abhijith.challenges.amazon;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 */

public class LongestIncreasingPath {

    private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void findSolution() {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6}};

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];

        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int longest = dfs(matrix, m, n, i, j, mem);
                longestPath = Math.max(longestPath, longest);
            }
        }

        System.out.println(longestPath);
    }

    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] mem) {

        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int max = 0;
        for(int[] direction: DIRECTIONS) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if(x > -1 && y > -1 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                int longest = dfs(matrix, m, n, x, y, mem);
                max = Math.max(max, longest);
            }
        }
        mem[i][j] = max + 1;

        return mem[i][j];
    }

}
