package io.abhijith.challenges.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Find number of distinct islands in a graph
 *
 * This is a spin off question from the problem Number of Islands.
 * The idea is to keep track of the direction of your recursion for every island and build a string based on that island.
 * https://www.youtube.com/watch?v=c1ZxUOHlulo&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=3
 *
 * Constructing recursion path with following Character representations
 * Start = X
 * Out of Bound | Water = O
 * Left = L
 * Right = R
 * Down = D
 * Up = U
 */

public class NumberOfDistinctIslands {

    public void findSolution() {
        char[][] graph = new char[][] {
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','1','1'},
			{'1','0','0','1','1'}
			};

        if(graph.length == 0 || graph == null) {
            System.out.println(0);
            return;
        }

        Set<String> distinctIslands = new HashSet<>();

        int m = graph.length, n = graph[0].length;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == '1') {
                    String s = computeIslandString(graph, i, j, m, n, "X");
//                    System.out.println(s);
                    distinctIslands.add(s);
                }
            }
        }
        System.out.println(distinctIslands.size());
    }

    public String computeIslandString(char[][] graph, int i, int j, int m, int n, String path) {

        if(i < 0 || j < 0 || i >= m || j >= n || graph[i][j] == '0')
            return "O";
        graph[i][j] = '0';
        String left = computeIslandString(graph, i, j - 1, m, n, "L");
        String right = computeIslandString(graph, i, j + 1, m, n, "R");
        String up = computeIslandString(graph, i - 1, j, m, n, "U");
        String down = computeIslandString(graph, i + 1, j, m, n, "D");
        return path + left + right + up + down;
    }

}
