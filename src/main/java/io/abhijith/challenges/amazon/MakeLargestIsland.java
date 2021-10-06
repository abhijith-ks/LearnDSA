package io.abhijith.challenges.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 *
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 *
 * Example 1:
 *
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 */

public class MakeLargestIsland {

    public void findSolution() {

        int[][] area = new int[][]{
                {0,1,0,1,0},
                {1,1,0,0,1},
                {0,0,1,1,0}};

        if(area == null || area.length == 0) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int islandId = 2;
        int m = area.length;
        int n = area[0].length;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(area[i][j] == 1) {
                    int size = dfs(area, i, j, islandId);
                    map.put(islandId, size);
                    islandId++;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(area[i][j] == 0) {
                max = Math.max(max, maxArea(area, i, j, map));
                }
            }
        }

        System.out.println(max);
    }

    public int maxArea(int[][] area, int i, int j, Map<Integer, Integer> map) {

        Set<Integer> seenItems = new HashSet<>();
        int max = 0;
        if(i - 1 >= 0 && area[i - 1][j] != 0 && !seenItems.contains(area[i - 1][j])) {
            seenItems.add(area[i - 1][j]);
            max += map.get(area[i - 1][j]);
        }
        if(i + 1 < area.length && area[i + 1][j] != 0 && !seenItems.contains(area[i + 1][j])) {
            seenItems.add(area[i + 1][j]);
            max += map.get(area[i + 1][j]);
        }
        if(j - 1 >= 0 && area[i][j - 1] != 0 && !seenItems.contains(area[i][j - 1])) {
            seenItems.add(area[i][j - 1]);
            max += map.get(area[i][j - 1]);
        }
        if(j + 1 < area[0].length && area[i][j + 1] != 0 && !seenItems.contains(area[i][j + 1])) {
            seenItems.add(area[i][j + 1]);
            max += map.get(area[i][j + 1]);
        }

        return max + 1;
    }

    public int dfs(int[][] area, int i, int j, int islandId) {
        if(i < 0 || j < 0 || i >= area.length || j >= area[0].length || area[i][j] != 1) {
            return 0;
        }

        area[i][j] = islandId;
        int left = dfs(area, i, j - 1, islandId);
        int right = dfs(area, i, j + 1, islandId);
        int up = dfs(area, i - 1, j, islandId);
        int down = dfs(area, i + 1, j, islandId);
        return 1 + left + right + up + down;
    }

}
