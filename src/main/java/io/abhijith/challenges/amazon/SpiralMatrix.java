package io.abhijith.challenges.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */

public class SpiralMatrix {

    public void findSolution() {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> nums = new ArrayList<>();

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        int matrixSize = matrix.length * matrix[0].length;
        while(nums.size() < matrixSize) {
            for(int i = left; i <= right && nums.size() < matrixSize; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom && nums.size() < matrixSize; i++) {
                nums.add(matrix[i][right]);
            }
            right--;
            for(int i = right; i >= left && nums.size() < matrixSize; i--) {
                nums.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top && nums.size() < matrixSize; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
        }
        System.out.println(nums);
    }

}
