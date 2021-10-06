package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the root to given node path in Binary Tree
 */

public class RootToNodePathBT {

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

        List<String> path = new ArrayList<>();
        if(getPath(root, path, "15")) {
            System.out.println(path);
        } else {
            System.out.println(-1);
        }
    }

    public boolean getPath(BinaryTreeNode node, List<String> path, String val) {

        if(node == null) {
            return false;
        }

        path.add(node.getVal());

        if(node.getVal().equals(val)) {
            return true;
        }

        if(getPath(node.getLeft(), path, val) || getPath(node.getRight(), path, val)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
