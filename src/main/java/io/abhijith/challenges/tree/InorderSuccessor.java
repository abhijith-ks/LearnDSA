package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */

public class InorderSuccessor {

    BinaryTreeNode root = new BinaryTreeNode("4",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("1",null, null),
                    new BinaryTreeNode("3", null, null)),
            new BinaryTreeNode("7",
                    new BinaryTreeNode("6",null, null),
                    new BinaryTreeNode("9", null, null))
    );

    public void findSolution() {
        inorderTraversal(root);
        System.out.println("\nInorder Successor : " + inorderSuccessor(root, "4").getVal());
    }

    BinaryTreeNode next = null;

    public BinaryTreeNode inorderSuccessor(BinaryTreeNode node, String p) {
        if(node == null || p == null) {
            return next;
        }
        if(Integer.parseInt(node.getVal()) <= Integer.parseInt(p)) {
            inorderSuccessor(node.getRight(), p);
        } else {
            next = node;
            inorderSuccessor(node.getLeft(), p);
        }
        return next;
    }

    public void inorderTraversal(BinaryTreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.getLeft());
        System.out.print(" " + node.getVal());
        inorderTraversal(node.getRight());
    }

}

