package io.abhijith.challenges.amazon;

import io.abhijith.resources.BinaryTreeNode;

/**
 * Find lowest common ancestor of a BINARY TREE
 *
 * https://www.youtube.com/watch?v=xuvw11Ucqs8&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=16
 */

public class LowestCommonAncestorBinaryTree {

    BinaryTreeNode root = new BinaryTreeNode("3",
            new BinaryTreeNode("6",
                    new BinaryTreeNode("2", null, null),
                    new BinaryTreeNode("11",
                            new BinaryTreeNode("9", null, null),
                            new BinaryTreeNode("5", null, null))),
            new BinaryTreeNode("8",
                    null,
                    new BinaryTreeNode("13",
                            new BinaryTreeNode("7", null, null), null)));

    BinaryTreeNode result;

    public void findSolution() {
        findLCA(root, "11", "5");
        System.out.println(result.getVal());
        BinaryTreeNode result1 = lowestCommonAncestor(root, "11", "5");
        System.out.println(result1.getVal());
    }

    public boolean findLCA(BinaryTreeNode node, String p, String q) {

        if(node == null)
            return false;

        boolean left = findLCA(node.getLeft(), p, q);
        boolean right = findLCA(node.getRight(), p, q);
        boolean current = node.getVal().equals(p) || node.getVal().equals(q);

        if((left && right) || (right && current) || (left && current))
            result = node;

        return left || right || current;
    }

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode node, String p, String q) {
        if(node == null) {
            return null;
        }
        if(node.getVal().equals(p) || node.getVal().equals(q)) {
            return node;
        }
        BinaryTreeNode left = lowestCommonAncestor(node.getLeft(), p, q);
        BinaryTreeNode right = lowestCommonAncestor(node.getRight(), p, q);
        if(left != null && right != null)
            return node;
        return left == null ? right : left;
    }

}
