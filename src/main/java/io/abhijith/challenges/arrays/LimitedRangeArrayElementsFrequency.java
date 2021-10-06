package io.abhijith.challenges.arrays;

/**
 * Given an array A[] of N positive integers which can contain integers from 1 to N
 * where elements can be repeated or can be absent from the array.
 * Your task is to count the frequency of all elements from 1 to N.
 *
 * Input:
 * N = 5
 * A[] = {2,3,2,3,5}
 * Output:
 * 0 2 2 0 1
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 */

public class LimitedRangeArrayElementsFrequency {

    public void findSolution() {

        int[] arr = {2,3,2,3,5};
        int length = arr.length;

        int i = 0;
        while( i < length) {
            if(arr[i] <= 0) {
                i++;
                continue;
            }
            int index = arr[i] - 1;
            if(arr[index] > 0) {
                arr[i] = arr[index];
                arr[index] = -1;
            } else {
                arr[index]--;
                arr[i] = 0;
                i++;
            }
        }

        for(i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                arr[i] *= -1;
            }
            System.out.print("\t" + arr[i]);
        }
    }

}
