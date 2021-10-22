package io.abhijith.challenges.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You have a graph of n nodes.
 * You are given an integer n and an array edges
 * where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 */

public class NumberOfConnectedComponents {

    int countVar;

    public void findSolution() {
        System.out.println(countComponents(4,
                new int[][]{{0,1},{2,3},{1,2}}));
    }

    Map<Integer, Node> nodeMap = new HashMap<>();

    class Node {
        int value;
        Node parent;
        int rank;
        Node(int value) {
            this.value = value;
        }
    }

    private void makeSet(int value) {
        Node node = new Node(value);
        node.rank = 1;
        node.parent = node;
        nodeMap.put(value, node);
    }

    private Node find(int value) {
        return find(nodeMap.get(value));
    }

    private Node find(Node node) {
        if(node.parent == node) {
            return node;
        }
        node.parent = find(node.parent);
        return node.parent;
    }

    private void union(int firstValue, int secondValue) {
        Node first = find(firstValue);
        Node second = find(secondValue);

        if(first == second) {
            return;
        }

        if(first.rank > second.rank) {
            second.parent = first;
            first.rank++;
        } else {
            first.parent = second;
            second.rank++;
        }
        countVar--;
    }

    public int countComponents(int n, int[][] edges) {
        countVar = n;
        for(int i = 0; i < n; i++) {
            makeSet(i);
        }

        for(int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
            union(edges[i][1], edges[i][0]);
        }

        Set<Node> parents = new HashSet<>();
        for(int i = 0; i < n; i++) {
            parents.add(nodeMap.get(i).parent);
        }


        return countVar;
    }
}
