package io.abhijith.challenges.dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobber {

    int[] nums = new int[]{1, 2, 3, 1};

    public void findSolution() {
        int[] maxArray = new int[nums.length + 1];
         maxArray[0] = 0;
         maxArray[1] = nums[0];
         for(int i = 2; i <= nums.length; i++) {
             maxArray[i] = Math.max(nums[i - 1] + maxArray[i - 2], maxArray[i - 1]);
         }

        System.out.println(betterSolution(nums));
    }

    private int betterSolution(int[] nums) {
        int first = 0;
        int second = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }

        return second;
    }

}
