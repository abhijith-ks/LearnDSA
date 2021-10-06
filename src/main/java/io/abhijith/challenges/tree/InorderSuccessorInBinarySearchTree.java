package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Find the inorder successor of a node in binary search tree
 * Cases:
 *  1. If the node does have a right child, then inorder successor will be the minimum node in right subtree
 *  2. If the node does not have a right child, then the right ancestor of the node's subtree will be inorder successor
 */

public class InorderSuccessorInBinarySearchTree {

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
        System.out.println();
        BinaryTreeNode inorderSuccessor = getInorderSuccessor(root, "6");
        if(inorderSuccessor == null) {
            System.out.println( - 1);
        } else {
            System.out.println("\n" + inorderSuccessor.getVal());
        }

    }

    private BinaryTreeNode getInorderSuccessor(BinaryTreeNode node, String val) {

        if(node == null)
            return null;

        BinaryTreeNode current = findNode(node, val);

        if(current.getRight() != null) { // Case 1 -> node have a right child
            current = current.getRight();
            while(current.getLeft() != null) current = current.getLeft();
            return current;
        }
        else { // Case 2 -> Node does not have a right child
            BinaryTreeNode ancestor = root;
            BinaryTreeNode successor = null;
            while(ancestor != current) {
                if(stoi(ancestor.getVal()) < stoi(val)) {
                    ancestor = ancestor.getRight();
                } else {
                    successor = ancestor;
                    ancestor = ancestor.getLeft();
                }
            }
            return successor;
        }
    }

    private BinaryTreeNode findNode(BinaryTreeNode node, String val) {
        if(node == null)
            return null;
        if(stoi(node.getVal()) == stoi(val)) {
            return node;
        }
        else if(stoi(node.getVal()) < stoi(val)) {
            node = findNode(node.getRight(), val);
        } else {
            node = findNode(node.getLeft(), val);
        }
        return node;
    }

    private void inorderTraversal(BinaryTreeNode node) {
        if(node == null)
            return;
        inorderTraversal(node.getLeft());
        System.out.print("\t" + node.getVal());
        inorderTraversal(node.getRight());
    }

    private Integer stoi(String s) {
        return Integer.parseInt(s);
    }

}
