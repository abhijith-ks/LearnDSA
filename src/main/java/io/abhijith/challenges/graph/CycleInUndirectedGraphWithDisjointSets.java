package io.abhijith.challenges.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Check whether a undirected graph having cycle using DisjointSets
 */

public class CycleInUndirectedGraphWithDisjointSets {

    Map<Integer, Node> map = new HashMap<>();

    class Node {
        int rank;
        int data;
        Node parent;
    }

    public void makeSet(int vertex) {
        Node node = new Node();
        node.data = vertex;
        node.parent = node;
        node.rank = 0;
        map.put(vertex, node);
    }

    public Node findSet(Node node) {
        if(node.parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public Node findSet(int data) {
        return findSet(map.get(data));
    }

    public void union(Node node1, Node node2) {
//        while(node1.parent != node1) {
//            node1 = node1.parent;
//        }
//        while (node2.parent != node2) {
//            node2 = node2.parent;
//        }
        node1 = findSet(node1);
        node2 = findSet(node2);

        if(node1.rank >= node2.rank) {
            if(node1.rank == node2.rank) {
                node1.rank++;
            }
            node2.parent = node1;
        } else {
            node1.parent = node2;
        }

    }

    public void findSolution() {

        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);

        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{4, 5});
//        edges.add(new int[]{5, 1});

        boolean cycleExists = false;

        for(int[] edge : edges) {
            if(findSet(edge[0]) == findSet(edge[1])) {
                cycleExists = true;
            } else {
                union(map.get(edge[0]), map.get(edge[1]));
            }
        }

        System.out.println(cycleExists);
    }

}
