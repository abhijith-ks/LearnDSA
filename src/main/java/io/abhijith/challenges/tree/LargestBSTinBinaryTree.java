package io.abhijith.challenges.tree;

/* *
 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 *
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree.
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 *
 * References:
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 * https://leetcode.com/problems/largest-bst-subtree/
 * https://youtu.be/4fiDs7CCxkc
 */

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestBSTinBinaryTree {

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
        MinMax result = traverse(root);
        System.out.println(result.size);
    }

    private MinMax traverse(BinaryTreeNode node) {

        if(node == null) {
            return new MinMax();
        }

        MinMax left = traverse(node.getLeft());
        MinMax right = traverse(node.getRight());

        MinMax currentMinMax = new MinMax();

        if (left.isBST && right.isBST && left.maxValue < Integer.parseInt(node.getVal()) && right.minValue > Integer.parseInt(node.getVal())) {
            currentMinMax.isBST = true;
            currentMinMax.minValue = node.getLeft() != null ? left.minValue : Integer.parseInt(node.getVal());
            currentMinMax.maxValue = node.getRight() != null ? right.maxValue : Integer.parseInt(node.getVal());
            currentMinMax.size = left.size + right.size + 1;
            return currentMinMax;
        }
        currentMinMax.size = Math.max(left.size, right.size);
        currentMinMax.isBST = false;
        return currentMinMax;
    }


    class MinMax {
        boolean isBST;
        int minValue;
        int maxValue;
        int size;

        MinMax() {
            isBST = true;
            minValue = Integer.MAX_VALUE;
            maxValue = Integer.MIN_VALUE;
            size = 0;
        }
    }


//    Alternate Solution with O(n^2) complexity

    private void findSolutionAnother() {

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            int getValue = getBSTSize(node);
            max = Math.max(max, getValue);
            if(node.getLeft() != null) queue.add(node.getLeft());
            if(node.getRight() != null) queue.add(node.getRight());
        }

        System.out.println(max);
    }

    List<Integer> inorderList = new ArrayList<>();

    private int getBSTSize(BinaryTreeNode node) {

        boolean isBST = true;
        inorderList.clear();
        inorderTraversal(node, inorderList);
        if(inorderList.size() < 2) {
            return inorderList.size();
        }
        for(int i = 1; i < inorderList.size(); i++) {
            if(inorderList.get(i - 1) > inorderList.get(i)) {
                isBST = false;
                break;
            }
        }
        return isBST ? inorderList.size() : 0;
    }

    private void inorderTraversal(BinaryTreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.getLeft(), list);
        list.add(stoi(node.getVal()));
        inorderTraversal(node.getRight(), list);
    }

    private int stoi(String s) {
        return Integer.parseInt(s);
    }
}