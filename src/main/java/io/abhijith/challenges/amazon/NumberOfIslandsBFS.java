package io.abhijith.challenges.amazon;

import io.abhijith.challenges.problems.Powerset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find number of islands in a grid using BFS algorithm
 * Island - Combination of 1s in the grid in top/right/left/bottom direction
 */

public class NumberOfIslandsBFS {

    char[][] grid =  {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
			};

    char[][] gridCopy =  {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };

    public void findSolution() {

        int m  = grid.length;
        int n = grid[0].length;

        if(grid.length == 0 || grid == null) {
            return;
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    bfsApproach(grid, m, n, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        iterativeApproach(gridCopy);

    }

    public void iterativeApproach(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    if(!(i > 0 && grid[i - 1][j] == '1' || j > 0 && grid[i][j - 1] == '1'))
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfsApproach(char[][] grid, int m, int n, int i, int j) {
        Position position = new Position(i,j);
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            grid[pos.x][pos.y] = '0';
            if(pos.x > 0 && grid[pos.x - 1][pos.y] == '1') {
                queue.add(new Position(pos.x - 1, pos.y));
            }
            if(pos.y > 0 && grid[pos.x][pos.y - 1] == '1') {
                queue.add(new Position(pos.x, pos.y - 1));
            }
            if(pos.x < m - 1 && grid[pos.x + 1][pos.y] == '1') {
                queue.add(new Position(pos.x + 1, pos.y));
            }
            if(pos.y < n - 1 && grid[pos.x][pos.y + 1] == '1') {
                queue.add(new Position(pos.x, pos.y + 1));
            }
        }
    }

}
