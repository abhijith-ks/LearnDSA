package io.abhijith.challenges.dp;

/**
 * Kadane's Algorithm to Maximum Sum Subarray Problem
 *
 * https://www.youtube.com/watch?v=86CQq3pKSUw
 */

public class KadaneAlgorithm {

    public void findSolution() {

//        int[] input = {-2, 3, 2, -1};
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        int currentSum = input[0];
        int maxSum = input[0];

        for (int i = 1; i < input.length; i++) {
            currentSum = Math.max(currentSum + input[i], input[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        bruteForceSolution(input);

    }

    public void bruteForceSolution(int[] input) {

        int sum = Integer.MIN_VALUE;

        for(int i = 0; i < input.length; i++) {
            int tempSum = 0;
            for (int j = i; j < input.length; j++) {
                tempSum += input[j];
                sum = Math.max(sum, tempSum);
            }
        }

        System.out.println(sum);
    }

}
