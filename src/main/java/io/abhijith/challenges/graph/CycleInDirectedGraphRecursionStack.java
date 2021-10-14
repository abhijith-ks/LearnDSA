package io.abhijith.challenges.graph;

import java.util.*;

/**
 * Given a directed graph, check whether the graph contains a cycle or not.
 * Your function should return true if the given graph contains at least one cycle,
 * else return false.
 *
 * Recursion Stack method
 */

public class CycleInDirectedGraphRecursionStack {

    Map<Integer, List<Integer>> adjList;

    class Graph {
        int v;
        Graph(int v) {
            this.v = v;
            adjList = new HashMap<>();
        }
    }

    public void findSolution() {
        Graph graph = new Graph(5);
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{2, 0});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 2});

        for(int[] edge : edges) {
            if(adjList.containsKey(edge[0])) {
                adjList.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                adjList.put(edge[0], list);
            }
        }

        boolean[] visited = new boolean[graph.v];
        boolean[] recStack = new boolean[graph.v];

        boolean cycleFlag = false;

        for(int i = 0; i < graph.v; i++) {
            if(!visited[i])
                cycleFlag = isCycleExists(i, visited, recStack);
        }
        System.out.println(cycleFlag);
    }

    private boolean isCycleExists(int v, boolean[] visited, boolean[] recStack) {
        if(recStack[v])
            return true;

        if(visited[v])
            return false;

        recStack[v] = true;
        visited[v] = true;

        List<Integer> neighbours = adjList.get(v);
        if(neighbours != null && neighbours.size() != 0) {
            for (Integer neighbour : neighbours) {
                if (isCycleExists(neighbour, visited, recStack))
                    return true;
            }
        }
        recStack[v] = false;
        return false;
    }

}
