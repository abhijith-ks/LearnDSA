package io.abhijith.challenges.graph;

import java.util.*;

public class CycleInDirectedGraphWithAdjList {

    Set<Integer> whiteSet = new HashSet<>();
    Set<Integer> graySet = new HashSet<>();
    Set<Integer> blackSet = new HashSet<>();

    class AdjList {
        int V;
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        AdjList(int V) {
            this.V = V;
        }
    }

    public boolean containsCycle(AdjList adjList) {
        while (!whiteSet.isEmpty()) {
            Integer current = whiteSet.iterator().next();
            if(dfs(current, adjList)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int current, AdjList adjList) {
        whiteSet.remove(current);
        graySet.add(current);
        if (adjList.edges.containsKey(current)) {
            Set<Integer> neighbours = adjList.edges.get(current);
            for (Integer neighbour : neighbours) {
                if (blackSet.contains(neighbour)) {
                    continue;
                }
                if (graySet.contains(neighbour)) {
                    return true;
                }
                if (dfs(neighbour, adjList)) {
                    return true;
                }
            }
        }
        graySet.remove(current);
        blackSet.add(current);
        return false;
    }

    public void findSolution() {
        AdjList adjList = new AdjList(5);
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{3, 1});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 5});
        edges.add(new int[]{5, 3});

        for(int[] edge : edges) {
            if(adjList.edges.containsKey(edge[0])) {
                adjList.edges.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(edge[1]);
                adjList.edges.put(edge[0], list);
            }
        }

        for (int i = 0; i < adjList.V; i++) {
            whiteSet.add(i + 1);
        }

        System.out.println(containsCycle(adjList));
    }

}
