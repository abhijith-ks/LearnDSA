package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a Binary Search Tree (BST), modify it so that all greater values in the given BST are added to every node.
 * For example, consider the following BST.
 *               50
 *            /      \
 *          30        70
 *         /   \      /  \
 *       20    40    60   80
 *
 * The above tree should be modified to following
 *
 *               260
 *            /      \
 *          330        150
 *         /   \       /  \
 *       350   300    210   80
 *
 * Method: Modify postorder traversal.
 */

public class AddGreaterValueNodeToEveryNode {

    BinaryTreeNode root = new BinaryTreeNode("50",
            new BinaryTreeNode("30",
                    new BinaryTreeNode("20",null,null),
                    new BinaryTreeNode("40",null,null)),
            new BinaryTreeNode("70",
                    new BinaryTreeNode("60",null,null),
                    new BinaryTreeNode("80",null,null))
            );

    public void findSolution() {
        Sum sum = new Sum();
        addGreaterValue(root, sum);
        inorderTraversal(root);
    }

//    Using the Sum class instead of simple int is to maintain the computed value for further recursive calls
//    If we use simple int, older stack trace will have the value of old sum not the accumulated one from postorder traversal
    class Sum {
        int sum = 0;
    }

    public void addGreaterValue(BinaryTreeNode node, Sum s) {
        if(node == null)
            return;
        addGreaterValue(node.getRight(), s);
        s.sum = s.sum + Integer.parseInt(node.getVal());
        node.setVal("" + s.sum);
        addGreaterValue(node.getLeft(), s);
    }

    public void inorderTraversal(BinaryTreeNode node) {
        if(node == null)
            return;
        inorderTraversal(node.getLeft());
        System.out.print("\t" + node.getVal());
        inorderTraversal(node.getRight());
    }

}
