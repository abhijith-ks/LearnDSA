package io.abhijith.challenges.dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobberTwo {

    int[] nums = new int[] {2,3,2};

    public void findSolution() {
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
//         int first = 0;
//         int second = nums[0];

//         for(int i = 1; i < nums.length - 1; i++) {
//             int current = Math.max(nums[i] + first, second);
//             first = second;
//             second = current;
//         }

//         int result = second;
//         first = 0;
//         second = nums[nums.length - 1];

//         for(int i = nums.length - 2; i > 0; i--) {
//             int current = Math.max(second, nums[i] + first);
//             first = second;
//             second = current;
//         }

//         return Math.max(result, second);

        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(maxInArray(nums, 0, nums.length - 2), maxInArray(nums, 1, nums.length - 1));
    }

    private int maxInArray(int[] nums, int starting, int ending) {
        int first = 0;
        int second = nums[starting];

        for(int i = starting + 1; i <= ending; i++) {
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }

        return second;
    }
}
