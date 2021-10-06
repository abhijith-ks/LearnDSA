package io.abhijith.challenges.tree;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next()will return the next smallest number in the BST.
 * Note:next() and hasNext()should run in average O(1) time and uses O(h) memory, wherehis the height of the tree.
 */

public class BinarySearchTreeIterator {

    class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    public void findSolution() {

        Node root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        iterator(root);
        System.out.println(hasNext());
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(hasNext());
        System.out.println(next().value);
        System.out.println(next().value);
        System.out.println(hasNext());
    }

    Stack<Node> stack = new Stack<>();

    private boolean hasNext() {
        return !stack.isEmpty();
    }

    private void iterator(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private Node next() {
        Node node = stack.pop();
        Node iterator = node.right;
        while(iterator != null) {
            stack.push(iterator);
            iterator = iterator.left;
        }
        return node;
    }

}
