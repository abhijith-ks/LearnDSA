package io.abhijith.challenges.tree;

/**
 * Given Preorder traversal of a BST, check if each non-leaf node has only one child. Assume that the BST contains unique entries.
 *
 * Input: pre[] = {20, 10, 11, 13, 12}
 * Output: Yes
 * The give array represents following BST. In the following BST, every internal
 * node has exactly 1 child. Therefor, the output is true.
 *         20
 *        /
 *       10
 *        \
 *         11
 *           \
 *            13
 *            /
 *          12
 * Refer: https://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 * Explanation: As we know that when we visit one node, the next one in preorder traversal will be the left node.
 *              If and ends with right node. So every time we check for every node, whether the next in the pre order
 *              traversal list and the last one in the list are either both increasing or both decreasing
 */

public class BSTOneChildPreOrderTraversal {

    public void findSolution() {

        int[] pre = new int[]{20, 10, 11, 13, 12};
        System.out.println(checkOneChildRelationOptimal(pre));
        System.out.println(checkOneChildRelationBruteForce(pre));
    }

    public boolean checkOneChildRelationOptimal(int[] pre) {
        if(pre.length <= 2) {
            return true;
        }
        for(int i = 0; i < pre.length - 1; i++) {
            if((pre[i] - pre[i + 1]) * (pre[i] - pre[pre.length - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkOneChildRelationBruteForce(int[] pre) {
        boolean increasing = true, decreasing = true;
        for (int i = 0; i < pre.length; i++) {
            for (int j = i + 1; j < pre.length; j++) {
                if(pre[i] > pre[j]) {
                    increasing = false;
                } else if(pre[i] < pre[j]){
                    decreasing = false;
                }
            }
            if(!increasing && !decreasing) {
                return false;
            }
            increasing = true; decreasing = true;
        }
        return true;
    }

}
