package io.abhijith.challenges.amazon;

/**
 * Find All Duplicates in Array
 */

public class FindDuplicatesInArray {

    public void findSolution() {
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};

        for(int i = 0; i < input.length; i++) {
            int index = Math.abs(input[i]);
            if(input[index - 1] < 0) {
                System.out.print("\t" + Math.abs(input[i]));
            } else {
                input[index - 1] *= -1;
            }
        }

    }

}
