package io.abhijith.challenges.dp;

import java.util.Arrays;

/**
 * Find maximum sum rectangle in 2D matrix.
 */

public class MaximumSumRectangleSubMatrixInMatrix {

    int[][] matrix = {
            {2, 1, -3, -4, 5},
            {0, 6, 3, 4, 1},
            {2, -2, -1, 4, -5},
            {-3, 3, 1, 0, 3}
    };

    public void findSolution() {

        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = 0, maxLeft = 0, maxRight = 0, maxTop = 0, maxBottom = 0;
        int temp[] = new int[m];
        for(int l = 0; l < n; l++) {
            Arrays.fill(temp, 0);
            for(int r = l; r < n; r++) {
                for(int i = 0; i < m; i++) {
                    temp[i] += matrix[i][r];
                }
                KadaneResult kadaneResult = getMaxSumArray(temp);
                if(maxSum < kadaneResult.maxSum) {
                    maxSum = kadaneResult.maxSum;
                    maxLeft = l;
                    maxRight = r;
                    maxTop = kadaneResult.start;
                    maxBottom = kadaneResult.end;
                }
            }
        }
        System.out.println("Co-ordinates : (" + maxTop + "," + maxLeft + ")," +
                                            "(" + maxTop + "," + maxRight + ")," +
                                            "(" + maxBottom + "," + maxLeft + ")," +
                                            "(" + maxBottom + "," + maxRight + ")");

    }

    private KadaneResult getMaxSumArray(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;
        int currentStart = 0;
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if(currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
            if(maxSum < currentSum) {
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }
        }
        return new KadaneResult(maxSum, start, end);
    }

    class KadaneResult {
        int maxSum;
        int start;
        int end;
        KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

}
