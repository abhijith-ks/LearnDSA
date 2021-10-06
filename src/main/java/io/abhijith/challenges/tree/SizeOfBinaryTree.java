package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Calculate size of a binary tree
 */

public class SizeOfBinaryTree {

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
        System.out.println(findSize(root));
    }

    public int findSize(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }

        return 1 + findSize(node.getLeft()) + findSize(node.getRight());
    }

}
