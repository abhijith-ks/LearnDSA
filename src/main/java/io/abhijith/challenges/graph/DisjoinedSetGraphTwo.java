package io.abhijith.challenges.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoined Set
 */
public class DisjoinedSetGraphTwo {

    class Node {
        int data;
        Node parent;
        int rank;
    }

    Map<Integer, Node> nodeMap = new HashMap<>();

    public void makeSet(Integer data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        nodeMap.put(data, node);
    }

    public Node find(Integer data) {
        return find(nodeMap.get(data));
    }

    public Node find(Node node) {
        if(node.parent == node) {
            return node;
        }
        node.parent = find(node.parent);
        return node.parent;
    }

    public void union(Integer data1, Integer data2) {
        Node node1 = find(data1);
        Node node2 = find(data2);

        if(node1.rank > node2.rank) {
            node2.parent = node1;
        } else if(node2.rank > node1.rank) {
            node1.parent = node2;
        } else {
            node1.rank += 1;
            node2.parent = node1;
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

        System.out.println(find(1).data);
        System.out.println(find(2).data);
        System.out.println(find(3).data);
        System.out.println(find(4).data);
        System.out.println(find(5).data);
        System.out.println(find(6).data);
        System.out.println(find(7).data);

    }
}
