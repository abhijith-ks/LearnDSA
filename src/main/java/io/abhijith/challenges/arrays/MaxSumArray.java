package io.abhijith.challenges.arrays;

/**
 * Given an integer arraynums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaxSumArray {

    public void findSolution() {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int temp = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int var = arr[i];
            if(temp >= 0) {
                var += temp;
            }
            temp = var;
            max = Math.max(max, temp);
        }

        System.out.println(max);

    }

}
