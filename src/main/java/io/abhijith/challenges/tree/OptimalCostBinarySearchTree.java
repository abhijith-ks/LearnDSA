package io.abhijith.challenges.tree;

/**
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
 * where freq[i] is the number of searches to keys[i].
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
 * Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.
 */

public class OptimalCostBinarySearchTree {

    public void findSolution() {

        int[] input = {10, 12, 20};//{10, 12, 20, 35, 46};
        int[] freq = {34, 8, 50};//{34, 8, 50, 21, 16};

        System.out.println(getMinCost(input, freq));

    }

    private int getMinCost(int[] input, int[] freq) {

        int[][] matrix = new int[input.length][freq.length];

        for(int i = 0; i < input.length; i++) {
            matrix[i][i] = freq[i];
        }

        for(int l = 2; l <= freq.length; l++) {
            for(int i = 0; i <= freq.length - l; i++) {
                int j = i + l - 1;
                int sum = getSum(freq, i, j);
                matrix[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    int leftVal = 0;
                    int rightVal = 0;
                    if(k - 1 >= i) {
                        leftVal = matrix[i][k - 1];
                    }
                    if(k + 1 <= j) {
                        rightVal = matrix[k + 1][j];
                    }
                    if(matrix[i][j] > sum + leftVal + rightVal) {
                        matrix[i][j] = sum + leftVal + rightVal;
                    }
                }
            }
        }
        return matrix[0][input.length - 1];
    }

    private int getSum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

}
