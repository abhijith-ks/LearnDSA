package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Implement graph traversal algorithms
 *      1. Preorder traversal
 *      2. Inorder traversal
 *      3. Postorder traversal
 */

public class BinaryTreeTraversal {

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
        System.out.println("\nPreorder Traversal");
        preorderTraversal(root);
        System.out.println("\nInorder Traversal");
        inorderTraversal(root);
        System.out.println("\nPostorder Traversal");
        postorderTraversal(root);
    }

    public void postorderTraversal(BinaryTreeNode node) {
        if (node == null)
            return;
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        System.out.print("\t" + node.getVal());
    }

    public void inorderTraversal(BinaryTreeNode node) {
        if(node == null)
            return;
        inorderTraversal(node.getLeft());
        System.out.print("\t" + node.getVal());
        inorderTraversal(node.getRight());
    }

    public void preorderTraversal(BinaryTreeNode node) {
        if(node == null)
            return;
        System.out.print("\t" + node.getVal());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }
}
