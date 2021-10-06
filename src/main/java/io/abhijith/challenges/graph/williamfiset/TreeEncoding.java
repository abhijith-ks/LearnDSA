package io.abhijith.challenges.graph.williamfiset;

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encode a tree for serialization and comparison for isomorphism
 *
 * AHU algorithm
 * https://math.stackexchange.com/questions/3282114/can-someone-explain-what-is-this-proof-of-ahu-algorithm-for-tree-isomorphism-mea
 *
 * Currently the algorithm is for BinaryTree, but can be extend to any tree
 */

public class TreeEncoding {

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
        System.out.println(encode(root));
    }

    private String encode(BinaryTreeNode node) {
        if (node == null) {
            return "";
        }

        List<String> labels = new ArrayList<>(); // For normal tree (not binary tree) iterate through the children and add encoded string to labels
        labels.add(encode(node.getLeft()));
        labels.add(encode(node.getRight()));

        Collections.sort(labels);
        StringBuilder string = new StringBuilder();
        string.append(labels.get(0));
        string.append(labels.get(1));

        return "(" + string + ")";
    }
}
