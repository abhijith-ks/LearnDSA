package io.abhijith.challenges.graph.williamfiset;

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Find lowest common ancestor of any tree with Eulerian Path method
 */

public class LowestCommonAncestorEulerianPath {


    BinaryTreeNode root = new BinaryTreeNode("0",
            new BinaryTreeNode("1",
                    new BinaryTreeNode("3", null, null),
                    null),
            new BinaryTreeNode("2",
                    new BinaryTreeNode("4",
                            new BinaryTreeNode("6", null, null), null),
                    new BinaryTreeNode("5", null, null)));

    List<String> nodes;
    List<Integer> depth;

    public void findSolution() {
        setUp();
        dfs(root, 0);
        System.out.println(nodes);
        System.out.println(depth);

//        int i = 0;
        String item1 = "5";
        String item2 = "6";
        int index1 = 0, index2 = 0;
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(item1)) {
                index1 = i;
            }
            if(nodes.get(i).equals(item2)) {
                index2 = i;
            }
        }

        int l = Math.min(index1, index2);
        int r = Math.max(index1, index2);
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = 0;

        for(int i = l; i <= r; i++) {
            if(minValue > depth.get(i)) {
                minValue = depth.get(i);
                minValueIndex = i;
            }
        }

        System.out.println(nodes.get(minValueIndex));
    }

    private void setUp() {
        nodes = new ArrayList<>();
        depth = new ArrayList<>();
    }

    private void dfs(BinaryTreeNode node, Integer depth) {
        if(node == null) {
            return;
        }

        visit(node.getVal(), depth);
        dfs(node.getLeft(), depth + 1);
        visit(node.getVal(), depth);
        dfs(node.getRight(), depth + 1);
        visit(node.getVal(), depth);

    }

    private void visit(String node, Integer node_depth) {
        nodes.add(node);
        depth.add(node_depth);
    }
}
