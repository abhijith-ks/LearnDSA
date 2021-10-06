package io.abhijith.challenges.amazon;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges,
 * write a function to find the number of connected components in an undirected graph
 */

public class ConnectedComponentsInUndirectedGraph {

    class Node {
        int value;
        int rank;
        Node parent;

        Node(int value) {
            this.value = value;
            this.rank = 1;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public void makeSet(int value) {
        Node node = new Node(value);
        node.parent = node;
        map.put(value, node);
    }

    public Node findSet(int value) {
        Node node = map.get(value);
        if (node.parent == node) {
            return node;
        }

        node.parent = findSet(node.parent.value);
        return node.parent;
    }

    public Node union(Node node1, Node node2) {
        Node parent1 = findSet(node1.value);
        Node parent2 = findSet(node2.value);

        while (parent1.parent != node1) {
            parent1 = parent1.parent;
        }

        while (parent2.parent != node2) {
            parent2 = parent2.parent;
        }

        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
            return parent1;
        } else {
            parent1.parent = parent2;
            parent2.rank++;
            return parent2;
        }
    }

    public void findSolution() {
        int n = 5;
        for(int i = 0; i < n; i++) {
            makeSet(i);
        }
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{1, 2});
        edges.add(new int[]{3, 4});

        Set<Node> connectedVertices = new HashSet<>();

        for (int[] edge: edges) {
            connectedVertices.add(union(map.get(edge[0]), map.get(edge[1])));
        }

        System.out.println(connectedVertices.size());
    }

}
