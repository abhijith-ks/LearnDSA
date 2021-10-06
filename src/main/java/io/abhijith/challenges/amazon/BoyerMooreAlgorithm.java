package io.abhijith.challenges.amazon;

/**
 * Algorithm to find out the majority element in an array with O(n) time complexity and O(1) space complexity
 * Majority element: If n is the size of the array, then majority element will be the occurring more than n/2 times
 */

public class BoyerMooreAlgorithm {

    public void findSolution() {
        int[] arr = {2, 1, 2, 2, 2, 1, 1, 3, 2};
        int n = arr.length;

        if(arr == null || arr.length == 0) {
            return;
        }

        int candidate = arr[0];
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] != candidate) {
                count--;
            } else {
                count++;
            }
            if(count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }
        System.out.println(candidate);
    }

}
