package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement level order traversal in reverse order
 * From bottom to up
 */

public class ReverseLevelOrderTraversal {

    BinaryTreeNode root = new BinaryTreeNode("6",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("0", null, null),
                    new BinaryTreeNode("4",
                            new BinaryTreeNode("3", null, null),
                            new BinaryTreeNode("5", null, null))),
            new BinaryTreeNode("8",
                    new BinaryTreeNode("7", null, null),
                    new BinaryTreeNode("9", null, null)));

    public void findSolution() {

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            stack.push(node);
        }

        while (!stack.isEmpty()) {
            System.out.print("\t" + stack.pop().getVal());
        }

    }
}
