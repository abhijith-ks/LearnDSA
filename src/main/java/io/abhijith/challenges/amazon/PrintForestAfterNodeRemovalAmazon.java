package io.abhijith.challenges.amazon;

import io.abhijith.resources.BinaryTreeNode;

import java.util.*;

/**
 * Given a Binary Tree and an array arr[] consisting of values of nodes to be deleted,
 * the task is to print Inorder Traversal of the forests after deleting the nodes.
 *
 * https://www.geeksforgeeks.org/print-the-forests-of-a-binary-tree-after-removal-of-given-nodes/
 *
 * Time Complexity O(n)
 * Space Complexity O(1)
 */

public class PrintForestAfterNodeRemovalAmazon {

    BinaryTreeNode root = new BinaryTreeNode("10",
            new BinaryTreeNode("20",
                    new BinaryTreeNode("4", null, null),
                    new BinaryTreeNode("5", null, null)),
            new BinaryTreeNode("30",
                    null,
                    new BinaryTreeNode("7", null, null)));

    public void findSolution() {

        Set<Integer> valueSet = new HashSet<>();
        List<BinaryTreeNode> forestRoots = new ArrayList<>();
        Integer [] valueArray = {10, 5};
        Collections.addAll(valueSet, valueArray);
//        Set<Integer> valueSet = new HashSet<>(Arrays.asList(valueArray));
        postOrderTraversal(root, valueSet, forestRoots);

        System.out.println("Printing root values of forest");
        for (BinaryTreeNode node: forestRoots) {
            System.out.print("\t" + node.getVal());
        }

        System.out.println("\nInorder Traversal of forest");
        for(BinaryTreeNode node: forestRoots) {
            inorderTraversal(node, valueSet);
            System.out.println("\n\t ------- ");
        }

    }

    public void postOrderTraversal(BinaryTreeNode node, Set<Integer> valueSet, List<BinaryTreeNode> forestRoots) {
        if(node == null)
            return;

        postOrderTraversal(node.getLeft(), valueSet, forestRoots);
        postOrderTraversal(node.getRight(), valueSet, forestRoots);
        if(valueSet.contains(Integer.parseInt(node.getVal()))) {
            if(node.getLeft() != null) {
                forestRoots.add(node.getLeft());
            }
            if(node.getRight() != null) {
                forestRoots.add(node.getRight());
            }
        }
    }

    public void inorderTraversal(BinaryTreeNode node, Set<Integer> valueSet) {
        if(node == null || valueSet.contains(Integer.parseInt(node.getVal()))) {
            return;
        }
        inorderTraversal(node.getLeft(), valueSet);
        System.out.print("\t" +node.getVal());
        inorderTraversal(node.getRight(), valueSet);
    }

}
