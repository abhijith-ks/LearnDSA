package io.abhijith.challenges.graph.williamfiset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.
 *
 * You are given an m x n character matrix, grid, of these different types of cells:
 *
 * '*' is your location. There is exactly one '*' cell.
 * '#' is a food cell. There may be multiple food cells.
 * 'O' is free space, and you can travel through these cells.
 * 'X' is an obstacle, and you cannot travel through these cells.
 * You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
 *
 * Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
 *
 * https://leetcode.com/problems/shortest-path-to-get-food/
 */

public class ShortestPathBFS {

    public void findSolution() {
        char grid[][] = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
        System.out.println(getFood(grid));
    }

    boolean[][] visited;
    int[] rd;
    int[] cd;

    public int getFood(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        rd = new int[]{-1, 1, 0, 0};
        cd = new int[]{0, 0, -1, 1};
        int counter = 0;

        Queue<Integer> rqueue = new LinkedList<>();
        Queue<Integer> cqueue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '*') {
                    rqueue.add(i);
                    cqueue.add(j);
                    visited[i][j] = true;
                    break;
                }
            }
        }

        boolean flag = false;

        while(!rqueue.isEmpty()) {
            int size = rqueue.size();
            for(int j = 0; j < size; j++) {
                int r = rqueue.remove();
                int c = cqueue.remove();

                if(grid[r][c] == '#') {
                    flag = true;
                    break;
                }

                for(int i = 0; i < 4; i++) {
                    int rr = r + rd[i];
                    int cc = c + cd[i];

                    if(rr < 0 || rr >= grid.length || cc < 0 || cc >= grid[0].length
                            || grid[rr][cc] == 'X' || visited[rr][cc]) {
                        continue;
                    }
                    rqueue.add(rr);
                    cqueue.add(cc);
                    visited[rr][cc] = true;
                }
            }
            if(!flag)
                counter++;
        }

        return flag ? counter : -1;
    }

}
