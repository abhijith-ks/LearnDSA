package io.abhijith.challenges.graph;

import java.util.*;

/**
 * Implement topological sort
 */

public class TopologicalSort {

    Set<Integer> visited;
    Stack<Integer> stack;

    class AdjListGraph {
        int V;
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        AdjListGraph(int V) {
            this.V = V;
            visited = new HashSet<>();
            stack = new Stack<>();
        }
    }

    public void dfs(int current, AdjListGraph graph) {
        visited.add(current);
        if(graph.edges.containsKey(current)) {
            Set<Integer> neighbours = graph.edges.get(current);
            for (Integer neighbour: neighbours) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                dfs(neighbour, graph);
            }
        }
        stack.push(current);
    }

    public void findSolution() {
        AdjListGraph graph = new AdjListGraph(5);
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 5});

        for (int[] edge: edges) {
            if(graph.edges.containsKey(edge[0])) {
                graph.edges.get(edge[0]).add(edge[1]);
            } else  {
                Set<Integer> set = new HashSet();
                set.add(edge[1]);
                graph.edges.put(edge[0], set);
            }

        }


        while (stack.size() != 5) {
            for (int i = 1; i <=5; i++) {
                if(!stack.contains(i)) {
                    dfs(i, graph);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
