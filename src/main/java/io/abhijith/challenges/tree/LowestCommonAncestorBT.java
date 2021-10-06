package io.abhijith.challenges.tree;

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the lowest common ancestor for Binary Tree
 */

public class LowestCommonAncestorBT {

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


    public void findNodePath(BinaryTreeNode node, List<String> path, String value, boolean found, List<String> mainPath) {
        if (node == null || found) {
            return;
        }
        if (node.getVal() == value) {
            path.forEach(val -> {
                mainPath.add(val);
            });
            mainPath.add(value);
            return;
        }
        path.add(node.getVal());

        findNodePath(node.getLeft(), new ArrayList<>(path), value, found, mainPath);
        findNodePath(node.getRight(), new ArrayList<>(path), value, found, mainPath);
    }

    public void findSolution() {

        List<String> mainPath1 = new ArrayList<>();
        List<String> mainPath2 = new ArrayList<>();

        String value1 = "11";
        String value2 = "13";

        if (value1 == root.getVal() || value2 == root.getVal()) {
            System.out.println(root.getVal());
            return;
        }

        findNodePath(root, new ArrayList<>(), value1, false, mainPath1);
        findNodePath(root, new ArrayList<>(), value2, false, mainPath2);

        if (mainPath1.isEmpty() || mainPath2.isEmpty()) {
            System.out.println("Not Found");
            return;
        }

        if (mainPath1.size() > mainPath2.size()) {
            System.out.println(getCommonLowest(mainPath1, mainPath2));
        } else {
            System.out.println(getCommonLowest(mainPath2, mainPath1));
        }

    }

    public String getCommonLowest(List<String> firstList, List<String> secondList) {

//        firstList.forEach(System.out::print);
//        System.out.println();
//        secondList.forEach(System.out::print);
//        System.out.println();

        String prev = "";
        for (int i = 0; i < firstList.size(); i++) {
            if (secondList.size() == i) {
                break;
            }
            if (firstList.get(i).equals(secondList.get(i))) {
                prev = firstList.get(i);
                continue;
            } else {
                return prev;
            }
        }
        return prev;
    }
}
