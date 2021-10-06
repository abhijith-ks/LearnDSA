package io.abhijith.challenges.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Check whether a cycle exists in a directed graph
 * DFS solution
 * White-Gray-Black method
 */

public class CycleInDirectedGraph {

    class AdjMatrix {
        int V;
        int[][] graph;
        AdjMatrix(int v) {
            V = v;
            graph = new int[v + 1][v + 1];
        }
    }

    Set<Integer> whiteSet = new HashSet<>();
    Set<Integer> graySet = new HashSet<>();
    Set<Integer> blackSet = new HashSet<>();

    public boolean isCycleExists(AdjMatrix matrix) {
        while (!whiteSet.isEmpty()) {
            int current = whiteSet.iterator().next();
            if(dfs(current, matrix))
                return true;
        }
        return false;
    }

    public boolean dfs(int current, AdjMatrix matrix) {
        whiteSet.remove(current);
        graySet.add(current);
        for(int i = 1; i <= 5; i++) {
            if(matrix.graph[current][i] == 1) {
                if(blackSet.contains(i))
                    continue;
                if(graySet.contains(i))
                    return true;
                if(dfs(i, matrix))
                    return true;
            }
        }
        graySet.remove(current);
        blackSet.add(current);
        return false;
    }


    public void findSolution() {

        AdjMatrix matrix = new AdjMatrix(5);

        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{3, 1});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 5});
        edges.add(new int[]{5, 3});

        for(int[] edge : edges) {
            matrix.graph[edge[0]][edge[1]] = 1;
        }

        for(int i = 1; i <= 5; i++) {
            whiteSet.add(i);
        }

        System.out.println(isCycleExists(matrix));
    }

}
