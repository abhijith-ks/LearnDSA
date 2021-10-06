package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the longest root to leaf path in a tree
 */

public class LongestPathInTree {

    BinaryTreeNode root = new BinaryTreeNode("25",
            new BinaryTreeNode("18",
                    new BinaryTreeNode("19",
                            null,
                            new BinaryTreeNode("15", null, null)),
                    new BinaryTreeNode("20",
                            new BinaryTreeNode("18", null, null),
                            new BinaryTreeNode("25", null, null))),
            new BinaryTreeNode("50",
                    new BinaryTreeNode("35",
                            new BinaryTreeNode("20",
                                    null,
                                    new BinaryTreeNode("25", null, null)),
                            new BinaryTreeNode("40", null, null)),
                    new BinaryTreeNode("60",
                            new BinaryTreeNode("55", null, null),
                            new BinaryTreeNode("70", null, null))));

    public void findSolution() {

        List<String> longestPath = getLongestPath(root);
        for (int i = longestPath.size() - 1; i >= 0; i--) {
            System.out.print("\t" + longestPath.get(i));
        }

    }

    private List<String> getLongestPath(BinaryTreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }

        List<String> left = getLongestPath(node.getLeft());
        List<String> right = getLongestPath(node.getRight());

        if(left.size() > right.size()) {
            left.add(node.getVal());
        } else {
            right.add(node.getVal());
        }

        return left.size() > right.size() ? left : right;
    }

}
