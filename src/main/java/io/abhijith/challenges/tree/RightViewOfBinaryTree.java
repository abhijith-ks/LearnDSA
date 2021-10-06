package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a Binary Tree, print right view of it.
 * Right view of a Binary Tree is set of nodes visible when tree is visited from right side.
 *
 * Additional Question, can we do it without using queue
 */

public class RightViewOfBinaryTree {

    BinaryTreeNode root = new BinaryTreeNode("1",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("4", null, null),
                    new BinaryTreeNode("5",null,null)),
            new BinaryTreeNode("3",null,
                    new BinaryTreeNode("6", null, null)));

    class MaxLevel {
        int max_Level = 0;
    }

    public void findSolution() {
        MaxLevel maxLevel = new MaxLevel();
        rightSideView(root, 1, maxLevel);
    }

    public void rightSideView(BinaryTreeNode node, int level, MaxLevel maxLevel) {
        if(node == null)
            return;
        if(maxLevel.max_Level < level) {
            System.out.print("\t" + node.getVal());
            maxLevel.max_Level = level;
        }
        rightSideView(node.getRight(), level + 1, maxLevel);
        rightSideView(node.getLeft(), level + 1, maxLevel);
    }

}
