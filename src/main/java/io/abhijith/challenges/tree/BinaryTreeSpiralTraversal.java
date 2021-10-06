package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

import java.util.Stack;

/**
 * Print Level order traversal in spiral order for binary tree.
 *
 * Same as BFS but print from alternate side for levels
 */

public class BinaryTreeSpiralTraversal {

    BinaryTreeNode root = new BinaryTreeNode("6",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("0", null, null),
                    new BinaryTreeNode("4",
                            new BinaryTreeNode("3", null, null),
                            new BinaryTreeNode("5", null, null))),
            new BinaryTreeNode("8",
                    new BinaryTreeNode("7", null, null),
                    new BinaryTreeNode("9", null,
                            new BinaryTreeNode("1", null, null))));

    public void findSolution() {

        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        s1.add(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                BinaryTreeNode node = s1.pop();
                if(node.getLeft() != null)
                    s2.push(node.getLeft());
                if(node.getRight() != null)
                    s2.push(node.getRight());
                System.out.print("\t" + node.getVal());
            }
            while(!s2.isEmpty()) {
                BinaryTreeNode node = s2.pop();
                if(node.getRight() != null)
                    s1.push(node.getRight());
                if(node.getLeft() != null)
                    s1.push(node.getLeft());
                System.out.print("\t" + node.getVal());
            }
        }

    }

}
