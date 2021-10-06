package io.abhijith.challenges.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Check whether there is a path between given vertices in a undirected graph
 */

public class VertixToVertexPathSearchGraph {

    class AdjMatrixGraph {
        int V;
        int E;
        int[][] graph;
        int[] visited;
        AdjMatrixGraph(int vertex, int edges) {
            V = vertex;
            E = edges;
            graph = new int[vertex][vertex];
            visited = new int[vertex];
        }

        public void setGraph(int source, int destination) {
            graph[source - 1][destination - 1] = 1;
        }

        public void printGraph() {
            for(int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void dfs(int source) {

            for(int i = 0; i < V; i++) {
                if(visited[i] == 1) continue;
                if(graph[source - 1][i] == 1) {
                    visited[i] = 1;
                    dfs(i + 1);
                }
            }
        }
    }

    public void findSolution() {

        AdjMatrixGraph graph = new AdjMatrixGraph(6,5);
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1,2});
        edges.add(new int[]{2,3});
        edges.add(new int[]{3,1});
        edges.add(new int[]{2,6});
        edges.add(new int[]{4,5});

        for (int[] edge: edges) {
            graph.setGraph(edge[0], edge[1]);
            graph.setGraph(edge[1], edge[0]);
        }

//        graph.printGraph();

        graph.dfs(1);
        System.out.println(graph.visited[6 - 1]);

    }

}
