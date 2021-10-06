package io.abhijith.challenges.graph.williamfiset;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Dijkstra's Algorithm
 */


public class DijkstrasAlgorithm {

    class Edge {
        int from;
        int to;
        int weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    class Graph {
        int v;
        Map<Integer, List<Edge>> adjList;
        Graph(int v) {
            this.v = v;
            adjList = new HashMap<>();
        }
    }

    class MinVertex {
        int vertex;
        int value;
        MinVertex(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

    public void findSolution() {
        int[][] arr = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(arr, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Graph g = buildGraph(times, n);
        boolean[] visited  = new boolean[n];
        PriorityQueue<MinVertex> queue = new PriorityQueue<MinVertex>((a, b) -> a.value - b.value);
        MinVertex first = new MinVertex(k - 1, 0);
        queue.add(first);
        visited[k - 1] = true;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        while(!queue.isEmpty()) {
            MinVertex current = queue.poll();
            visited[current.vertex] = true;
            List<Edge> neighbours = g.adjList.get(current.vertex);
            if(neighbours != null) {
                for(Edge edge: neighbours) {
                    if(visited[edge.to]) continue;
                    if(current.value + edge.weight < distance[edge.to]) {
                        distance[edge.to] = current.value + edge.weight;
                        queue.add(new MinVertex(edge.to, distance[edge.to]));
                    }
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < distance.length; i++) {
            maxValue = Math.max(maxValue, distance[i]);
            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return maxValue;
    }

    private Graph buildGraph(int[][] times, int n) {
        Graph g = new Graph(n);
        for(int i = 0; i < times.length; i++) {
            Edge edge = new Edge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
            if(g.adjList.containsKey(edge.from)) {
                g.adjList.get(edge.from).add(edge);
            } else {
                List<Edge> list = new ArrayList<>();
                list.add(edge);
                g.adjList.put(edge.from, list);
            }
        }
        return g;
    }
}
