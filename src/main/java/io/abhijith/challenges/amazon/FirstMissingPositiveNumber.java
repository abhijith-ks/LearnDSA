package io.abhijith.challenges.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 *
 * https://www.youtube.com/watch?v=9SnkdYXNIzM&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=14
 */

public class FirstMissingPositiveNumber {

    public void findSolution() {
        int[] arr = {7, -2, 3, 1, 2, 20, -5};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for(int i = 1; i <= arr.length; i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }

        System.out.println(optimalSolution(arr));
    }

    public int optimalSolution(int[] arr) {

        boolean contains1 = false;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                contains1 = true;
            }
            else if(arr[i] < 1 || arr[i] > arr.length || arr[i] == 0) {
                arr[i] = 1;
            }
        }

        if(!contains1) {
            return 1;
        }

        for(int i = 0; i < arr.length; i++) {
            int index = arr[i];
            if(arr[Math.abs(index) - 1] > 0) {
                arr[Math.abs(index) - 1] *= -1;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                return  i + 1;
            }
        }

        return arr.length;
    }

}
