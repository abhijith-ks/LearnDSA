package io.abhijith.challenges.graph;

import java.util.*;

/**
 * A graph G is said to be minimally connected if removal of any edge makes the graph disconnected
 * ie, the minimally connected graph is a connected graph without any cycle
 */

public class MinimallyConnectedGraph {

    boolean cycleExists = false;

    class AdjMatrixGraph {
        int[][] graph;
        int V;
        List<Integer> visited;
        AdjMatrixGraph(int vertices) {
            V = vertices;
            graph = new int[vertices + 1][vertices + 1];
            visited = new ArrayList<>();
        }

        public void setGraph(int source, int destination) {
            graph[source][destination] = 1;
        }

        public boolean dfs(int vertex, int fromVertex) {
            visited.add(vertex);
            for (int i = 1; i <= V; i++) {
                if(graph[vertex][i] == 1) {
                    if(i == fromVertex)
                        continue;
                    if(visited.contains(i))
                        return true;
                    boolean hasCycle = dfs(i, vertex);
                    if(hasCycle) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public void findSolution() {

        int vertices = 5;
        AdjMatrixGraph graph = new AdjMatrixGraph(vertices);
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 5});
//        edges.add(new int[]{4, 2});

        for(int[] edge: edges) {
            graph.setGraph(edge[0], edge[1]);
        }
        System.out.println(graph.dfs(1, 0));
    }
}
