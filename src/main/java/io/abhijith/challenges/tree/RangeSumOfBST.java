package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Find the range sum of a binary search tree
 * You are given a range L and R,  traverse through the tree and sum the node values if it is in the range
 */

public class RangeSumOfBST {

    public void findSolution() {

        BinaryTreeNode root = new BinaryTreeNode("3",
                new BinaryTreeNode("9", null, null),
                new BinaryTreeNode("20",
                        new BinaryTreeNode("15", null, null),
                        new BinaryTreeNode("7", null, null)));

        System.out.println(dfs(root,7, 15, 0));
        System.out.println(dfs(root,7, 15));
    }

    public int dfs(BinaryTreeNode node, int L, int R, int sum) {

        if(node == null) {
            return sum;
        }

        int nodeVal = Integer.parseInt(node.getVal());

        if(nodeVal >= L && nodeVal <= R) {
            return nodeVal;
        }

        return dfs(node.getLeft(), L, R, sum) + dfs(node.getRight(), L, R, sum);
    }

    public int dfs(BinaryTreeNode node, int L, int R) {
        if(node == null) {
            return 0;
        }
        int nodeVal = Integer.parseInt(node.getVal());

        if(nodeVal >= L && nodeVal <= R) {
            return nodeVal;
        }
        return dfs(node.getLeft(), L, R) + dfs(node.getRight(), L, R);
    }

}
