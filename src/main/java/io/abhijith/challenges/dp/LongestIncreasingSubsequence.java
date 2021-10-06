package io.abhijith.challenges.dp;

/**
 * Find a subsequence in given array in which the subsequence's elements are
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 *
 * Dynamic Programming
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 */

public class LongestIncreasingSubsequence {

    public void findSolution() {

        int[] array = {3, 4, -1, 0, 6, 2, 3};
        int[] dpArray = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            dpArray[i] = 1;
        }

        for(int i = 1; i < array.length; i++) {
            int j = 0;
            while ( j < i) {

                if(array[j] < array[i]) {
                    if(dpArray[j] + 1 > dpArray[i]) {
                        dpArray[i] = dpArray[j] + 1;
                    }
                }
                j++;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < dpArray.length; i++) {
            max = Math.max(max, dpArray[i]);
        }

        System.out.println("Maximum length of longest increasing subsequence : " + max);

    }

}
