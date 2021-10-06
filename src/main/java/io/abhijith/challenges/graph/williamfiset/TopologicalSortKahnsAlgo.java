package io.abhijith.challenges.graph.williamfiset;

import io.abhijith.challenges.graph.TopologicalSort;

import java.util.*;

/**
 * Implement topological sort with Kahn's algorithm
 *
 * https://www.youtube.com/watch?v=cIBFEhD77b4&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=17
 */

public class TopologicalSortKahnsAlgo {

    class AdjListGraph {
        int V;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        AdjListGraph(int V) {
            this.V = V;
        }
    }

    public void findSolution() {
        AdjListGraph graph = new AdjListGraph(2);
        List<int[]> edges = new ArrayList<>();
//        edges.add(new int[]{1, 2});
//        edges.add(new int[]{2, 3});
//        edges.add(new int[]{3, 4});
//        edges.add(new int[]{4, 5});
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 1});

        for (int[] edge: edges) {
            if(graph.edges.containsKey(edge[0])) {
                graph.edges.get(edge[0]).add(edge[1]);
            } else  {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                graph.edges.put(edge[0], list);
            }
        }

        performSort(graph);
    }

    private void performSort(AdjListGraph graph) {
        int[] indegree = new int[graph.V];
        Map<Integer, List<Integer>> edges = graph.edges;
        Queue<Integer> queue = new LinkedList<>();

        for(Integer key: edges.keySet()) {
            for(int i = 0; i < indegree.length; i++) {
                if(edges.get(key).contains( i + 1)) {
                    indegree[i]++;
                }
            }
        }

        for(int i = 0; i < graph.V; i++) {
            if(indegree[i] == 0) {
                queue.add(i + 1);
            }
        }

        List<Integer> sortedList = new ArrayList<>();

        int counter = 0;
        while(!queue.isEmpty()) {
            counter++;
            int current = queue.remove();
            sortedList.add(current);
            List<Integer> items = graph.edges.get(current);
            if(items != null) {
                for (int item : items) {
                        if(--indegree[item - 1] == 0) {
                        queue.add(item);
                    }
                }
            }
        }

        if(counter != graph.V) {
            System.out.println("Graph contains cycle!");
            return;
        }

        for(Integer item: sortedList) {
            System.out.print(" " + item);
        }
    }

}
