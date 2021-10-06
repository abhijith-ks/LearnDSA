package io.abhijith.challenges.amazon;

import java.util.*;

/**
 * Given an undirected connected graph, create new graph by cloning the same
 *
 * https://www.youtube.com/watch?v=e5tNvT1iUXs&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=11
 */

public class CloneGraph {

    class Node {
        int val;
        List<Node> neighbours;

        Node(int val) {
            this.val = val;
            neighbours = new ArrayList<>();
        }
    }

    public void findSolution() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node3);
        node2.neighbours.add(node1);
        node2.neighbours.add(node4);
        node3.neighbours.add(node1);
        node3.neighbours.add(node4);
        node4.neighbours.add(node2);
        node4.neighbours.add(node3);

        Map<Integer, Node> nodeMap = new HashMap<>();
        Node finalNode = cloneGraph(node1, nodeMap);
        System.out.println(finalNode.neighbours.get(0).neighbours.get(1).val);

    }

    public Node  cloneGraph(Node node, Map<Integer, Node> nodeMap) {
        if(nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node newNode = new Node(node.val);
        nodeMap.put(node.val, newNode);
        for(Node neighbour: node.neighbours) {
            newNode.neighbours.add(cloneGraph(neighbour, nodeMap));
        }
        return newNode;
    }

}
