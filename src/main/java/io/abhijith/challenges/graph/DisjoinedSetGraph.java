package io.abhijith.challenges.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 *
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 */

public class DisjoinedSetGraph {

    Map<Integer, Node> map = new HashMap<>();

    class Node {
        int rank;
        int data;
        Node parent;
    }

    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public Node findSet(Node node) {
//        System.out.println("here");
        if(node.parent == node) {
//            return node.parent;
            return node;
        }
        node.parent = findSet(node.parent); // Path Compression can be eliminated if BLOCK A is active (Check line 53)
        return node.parent;
//        return findSet(node.parent);
    }

    public Node findSet(int data) {
        return findSet(map.get(data));
    }

    public void union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

//        BLOCK A
//        while(node1.parent != node1) {
//            node1 = node1.parent;
//        }
//
//        while (node2.parent != node2) {
//            node2 = node2.parent;
//        }
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1.data == parent2.data) {
            return;
        }

        if(parent1.rank >= parent2.rank) {
            if(parent1.rank == parent2.rank) {
                parent1.rank++;
            }
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }

    }

    public void findSolution() {

        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);
        makeSet(6);
        makeSet(7);

        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
//        union(5, 6);
        union(3, 7);

        System.out.println(findSet(1).data);
        System.out.println(findSet(2).data);
        System.out.println(findSet(3).data);
        System.out.println(findSet(4).data);
        System.out.println(findSet(5).data);
        System.out.println(findSet(6).data);
        System.out.println(findSet(7).data);

    }
}
