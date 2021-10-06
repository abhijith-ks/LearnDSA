package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */

public class UniValueSubtrees {

    BinaryTreeNode root = new BinaryTreeNode("5",
            new BinaryTreeNode("1",
                    new BinaryTreeNode("5",null, null),
                    new BinaryTreeNode("5", null, null)),
            new BinaryTreeNode("5",
                    null,
                    new BinaryTreeNode("5", null, null))
    );

    int totalCount = 0;

    public void findSolution() {
        isUnival(root, root.getVal());
        System.out.println(totalCount);
    }

    public boolean isUnival(BinaryTreeNode node, String rootVal) {
        if(node == null) {
            return true;
        }

        boolean left = isUnival(node.getLeft(), node.getVal());
        boolean right = isUnival(node.getRight(), node.getVal());
        if(left && right)
            totalCount++;
        return left && right && node.getVal().equals(rootVal);
    }

}
