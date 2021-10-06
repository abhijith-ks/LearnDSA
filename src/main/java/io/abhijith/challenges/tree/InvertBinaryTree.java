package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Invert a binary tree.
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */

public class InvertBinaryTree {

    BinaryTreeNode root = new BinaryTreeNode("4",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("1",null, null),
                    new BinaryTreeNode("3", null, null)),
            new BinaryTreeNode("7",
                    new BinaryTreeNode("6",null, null),
                    new BinaryTreeNode("9", null, null))
    );

    public void findSolution() {

        invertTree(root);
        System.out.println(root.getLeft().getRight().getVal());

    }

    public BinaryTreeNode invertTree(BinaryTreeNode node) {
        if(node == null) {
            return null;
        }
        BinaryTreeNode left = node.getLeft();
        node.setLeft(invertTree(node.getRight()));
        node.setRight(invertTree(left));
        return node;
    }

}
