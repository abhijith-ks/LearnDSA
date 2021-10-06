package io.abhijith.challenges.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the number of non recurring characters in a string
 */

public class NonRecurringCharactersInString {

    public void findSolution() {

        String s = "Programming";
        s = s.toLowerCase();
        int[] countArray = new int[26];
        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(countArray[i] == 1) {
                totalCount++;
            }
        }

        System.out.println(totalCount);
    }

}
