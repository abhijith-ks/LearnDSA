package io.abhijith.challenges.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N-ary tree containing, the task is to print the inorder traversal of the tree.
 */

public class N_aryTree {

    class Node {
        int value;
        Node[] children;
        Node(int n, int value) {
            this.value = value;
            children = new Node[n];
        }
    }

    public void traverse(Node node) {
        if(node == null) {
            return;
        }
        int childrenCount = node.children.length;
        for(int i = 0; i < childrenCount - 1; i++) {
            traverse(node.children[i]);
        }
        System.out.println(node.value);
        traverse(node.children[childrenCount - 1]);
    }

    int maxValue = Integer.MIN_VALUE;

    public int maxDepth(Node node, int depth) {
        if(node == null) {
            return depth;
        }
        Node[] childern = node.children;
        int newDepth = depth + 1;
        for(Node child: childern) {
            int current = maxDepth(child, newDepth);
            maxValue = Math.max(maxValue, current);
        }

        return Math.max(depth, maxValue);
    }

    public void findSolution() {

        int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[1] = new Node(n, 3);
        root.children[2] = new Node(n, 4);
        root.children[0].children[0] = new Node(n, 5);
        root.children[0].children[1] = new Node(n, 6);
        root.children[0].children[2] = new Node(n, 7);

        traverse(root);
        System.out.println("Max Depth : " + maxDepth(root, 0));

    }

}
