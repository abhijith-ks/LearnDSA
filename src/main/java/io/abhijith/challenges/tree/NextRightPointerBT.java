package io.abhijith.challenges.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 * Initially, all next pointers are set to NULL.
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * =>
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */

public class NextRightPointerBT {

    class Node {
        int val;
        Node left, right, next;
        Node(int val){
            this.val = val;
        }
    }

    public void findSolution() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        nextPointer(root);

        System.out.println(root.left.right.next.val);

    }

    public void nextPointer(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node previous = null;
            int size = queue.size();
            while(size > 0) {
                Node current = queue.poll();
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
                if(previous != null) {
                    previous.next = current;
                }
                previous = current;
                size--;
            }
        }

    }

}
