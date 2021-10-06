package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a Binary Tree, print left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 *
 * Additional Question, can we do it without using queue
 */

public class LeftViewOfBinaryTree {

    BinaryTreeNode root = new BinaryTreeNode("1",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("4", null, null),
                    new BinaryTreeNode("5",null,null)),
            new BinaryTreeNode("3",null,
                    new BinaryTreeNode("6", null, null)));

    public void findSolution() {
            leftSideView(root, 1);
    }

    int maxLevel = 0;

    public void leftSideView(BinaryTreeNode node, int level) {
        if(node == null)
            return;

        if(maxLevel < level) {
            System.out.print(node.getVal() + "\t");
            maxLevel = level;
        }

        leftSideView(node.getLeft(), level + 1);
        leftSideView(node.getRight(), level + 1);
    }

}
