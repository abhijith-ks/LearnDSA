package io.abhijith.challenges.amazon;

import io.abhijith.resources.BinaryTreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * NOTE: NOT REFERRING TO THE ROOT TO LEAF PATH
 */

public class BinaryTreeMaximumPathSum {

    BinaryTreeNode node = new BinaryTreeNode("10",
            new BinaryTreeNode("5",
                    new BinaryTreeNode("-5", null, null),
                    new BinaryTreeNode("1", null, null)),
            new BinaryTreeNode("-10",
                    new BinaryTreeNode("50", null, null),
                    new BinaryTreeNode("20", null, null)));

    int max = Integer.MIN_VALUE;

    public void findSolution() {
        System.out.println(getMaximum(node));
    }

    private int getMaximum(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = getMaximum(node.getLeft());
        int right = getMaximum(node.getRight());
        max = Math.max(max, left + right + Integer.parseInt(node.getVal()));
        return Math.max(left, right) + Integer.parseInt(node.getVal());
    }

}

