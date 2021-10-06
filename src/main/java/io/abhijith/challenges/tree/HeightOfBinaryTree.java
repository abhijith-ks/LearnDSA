package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Calculate height of binary tree
 */

public class HeightOfBinaryTree {

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
        System.out.println(getMaxHeight(root));
    }

    public int getMaxHeight(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getMaxHeight(node.getLeft()), getMaxHeight(node.getRight()));
    }

}
