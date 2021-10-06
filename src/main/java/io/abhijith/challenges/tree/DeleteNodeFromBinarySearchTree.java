package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Delete node from Binary Search Tree
 * 3 cases
 * -------
 * 1. If the node to be deleted is a child, delete the node
 * 2. If the node have one child, replace the node with child
 * 3. If the node have both children, then
 *      - Find the minimum in right subtree / maximum in left subtree
 *      - Swap the node with minNode / maxNode
 *      - Perform delete on swapped node (which have the initial node value)
 */

public class DeleteNodeFromBinarySearchTree {

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
        inorderTraversal(root);
        deleteNode(root, "8");
        System.out.println();
        inorderTraversal(root);
    }

    public void inorderTraversal(BinaryTreeNode node) {
        if(node == null)
            return;
        inorderTraversal(node.getLeft());
        System.out.print("\t" + node.getVal());
        inorderTraversal(node.getRight());
    }

    public BinaryTreeNode deleteNode(BinaryTreeNode node, String value) {

        if(node == null)
            return null;

        if(stoi(node.getVal()) < stoi(value)) {
            node.setRight(deleteNode(node.getRight(), value));
        }
        else if(stoi(node.getVal()) > stoi(value)) {
            node.setLeft(deleteNode(node.getLeft(), value));
        }
        else {
            if(node.getLeft() == null && node.getRight() == null) {
                node = null;
            }
            else if(node.getLeft() == null) {
                node = node.getRight();
            }
            else if(node.getRight() == null) {
                node = node.getLeft();
            }
            else {
                BinaryTreeNode minNode = getMin(node.getRight());
                node.setVal(minNode.getVal());
                node.setRight(deleteNode(node.getRight(), minNode.getVal()));
            }
        }
        return node;
    }

    private BinaryTreeNode getMin(BinaryTreeNode node) {
        if(node.getLeft() == null) {
            return node;
        }
        return node.getLeft();
    }

    private int stoi(String s) {
        return Integer.parseInt(s);
    }

}
