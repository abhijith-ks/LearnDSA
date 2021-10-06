package io.abhijith.challenges.tree;

/**
 * Implement level order traversal from right to left
 */

import io.abhijith.resources.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RightToLeftLevelOrderTraversal {

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

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.remove();
                if(node.getRight() != null )
                    queue.add(node.getRight());
                if(node.getLeft() != null )
                    queue.add(node.getLeft());
                System.out.print(" " + node.getVal());
            }
            System.out.println();
        }

    }
}

