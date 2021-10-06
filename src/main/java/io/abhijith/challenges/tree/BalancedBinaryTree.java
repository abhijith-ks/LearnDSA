package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of_every_node never differ by more than 1
 */

public class BalancedBinaryTree {

//    Not a balanced binary tree
//    BinaryTreeNode root = new BinaryTreeNode("5",
//            new BinaryTreeNode("4",
//                    new BinaryTreeNode("11",
//                            new BinaryTreeNode("7", null, null),
//                            new BinaryTreeNode("2",
//                                    new BinaryTreeNode("3", null, null), null)
//                    ), null),
//            new BinaryTreeNode("8",
//                    new BinaryTreeNode("13", null, null),
//                    new BinaryTreeNode("4", null,
//                            new BinaryTreeNode("1", null, null)
//                    )
//            )
//    );

//    Balanced Binary Tree
    BinaryTreeNode root = new BinaryTreeNode("1",
            new BinaryTreeNode("2",
                    new BinaryTreeNode("3",null, null),
                    new BinaryTreeNode("4", null, null)),
            new BinaryTreeNode("2",
                    new BinaryTreeNode("4",null, null),
                    new BinaryTreeNode("3", null, null))
    );

    boolean balanced = true;

    public void findSolution() {
        depth(root);
        System.out.println(balanced);
    }

    public int depth(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = depth(node.getLeft());
        int right = depth(node.getRight());
        if(Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }

}
