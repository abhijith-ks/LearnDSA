package io.abhijith.challenges.dp;

import java.util.Arrays;

/**
 * Find longest bitonic subsequence in given array. Bitonic subsequence first increases then decreases.
 */

public class LongestBitonicSubsequence {

    public void findSolution() {

        int[] nums = {2, -1, 4, 3, 5, -1, 3, 2};
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = nums.length - 1; j > i; j--) {
                if(nums[j] < nums[i] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, dp1[i] + dp2[i] - 1); // - 1 because same item is considered twice as we are having two arrays.
        }

        System.out.println(maxSum);
    }

}
