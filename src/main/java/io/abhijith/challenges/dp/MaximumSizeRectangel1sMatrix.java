package io.abhijith.challenges.dp;

import java.util.Stack;

/**
 * Given a 2D matrix of 0s and 1s, find maximum size rectangle of all 1s in this matrix.
 */

public class MaximumSizeRectangel1sMatrix {

    int[][] matrix = {
            {1, 0, 0, 1, 1, 1},
            {1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1}
    };

    public void findSolution() {

        if(matrix == null || matrix.length == 0) {
            return;
        }

        int[] temp = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += 1;
                }
                maxArea = Math.max(maxArea, getMaxAreaHistogram(temp));
            }
        }

        System.out.println(maxArea);
    }

    private int getMaxAreaHistogram(int[] arr) {
        int l = arr.length;
        int[] left = new int[l];
        int[] right = new int[l];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            if (stack.isEmpty()) {
                left[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    left[i] = 0;
                } else {
                    left[i] = stack.peek() + 1;
                }
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = l - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                right[i] = l - 1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    right[i] = l - 1;
                } else {
                    right[i] = stack.peek() - 1;
                }
                stack.push(i);
            }
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            maxArea = Math.max(maxArea, arr[i] * (right[i] - left[i] + 1));
        }
        return maxArea;
    }

}
