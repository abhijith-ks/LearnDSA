package io.abhijith.challenges.amazon;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * For 90 degrees clockwise rotation, take the transpose of matrix and reverse the row values
 */

public class RotateImage {

    public void findSolution() {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int length = matrix.length;
        for(int i = 0; i < length; i++) {
        	for(int j = i; j < length; j++) {
        	    int swapTemp = matrix[i][j];
        	    matrix[i][j] = matrix[j][i];
        	    matrix[j][i] = swapTemp;
        	}
        }

        System.out.println("Transpose Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        for(int i = 0; i < length; i++) {
            int j = 0, k = length - 1;
            while(j < k) {
                int swapTemp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = swapTemp;
                j++; k--;
            }
        }

        System.out.println("Rotated Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
