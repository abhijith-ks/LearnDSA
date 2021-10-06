package io.abhijith.challenges.dp;

import java.util.Arrays;

/**
 * Given an array of non negative numbers and a total,
 * check whether there is subset of numbers in this array which adds up to given total
 *
 * Dynamic Programming solution
 * Solution: https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=3
 */

public class SubsetSum {

    public void findSolution() {

        int[] input  = new int[]{1, 3, 5, 5, 2, 1, 1, 6};
        Arrays.sort(input);
        int sum = 11;

        boolean[][] dpMatrix = new boolean[input.length + 1][sum + 1];

        for(int i = 0; i <= input.length; i++) {
            dpMatrix[i][0] = true;
        }

        for(int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(input[i - 1] > j) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j];
                } else {
                    dpMatrix[i][j] = dpMatrix[i - 1][j] || dpMatrix[i - 1][j - input[i - 1]];
                }
            }
        }

        System.out.println(dpMatrix[input.length][sum]);
    }
}
