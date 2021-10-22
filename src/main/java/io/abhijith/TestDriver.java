package io.abhijith;

import io.abhijith.resources.BinaryTreeNode;

import java.util.Arrays;

public class TestDriver {

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
        System.out.println(traverse(root).size);
    }

    private MinMax traverse(BinaryTreeNode node) {
        if (node == null) {
            MinMax minMax = new MinMax();
            return minMax;
        }

        MinMax left = traverse(node.getLeft());
        MinMax right = traverse(node.getRight());

        MinMax currentMinMax = new MinMax();

        if(left.isBST && right.isBST && left.maxValue < Integer.parseInt(node.getVal()) && right.minValue > Integer.parseInt(node.getVal())) {
            currentMinMax.isBST = true;
            currentMinMax.minValue = node.getLeft() != null ? left.minValue : Integer.parseInt(node.getVal());
            currentMinMax.maxValue = node.getRight() != null ? right.maxValue : Integer.parseInt(node.getVal());
            currentMinMax.size = left.size + right.size + 1;
            return currentMinMax;
        }

        currentMinMax.isBST = false;
        currentMinMax.size = Math.max(left.size, right.size);
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



    public static void main(String[] args) {
        TestDriver driver = new TestDriver();
        driver.findSolution();
    }

}
