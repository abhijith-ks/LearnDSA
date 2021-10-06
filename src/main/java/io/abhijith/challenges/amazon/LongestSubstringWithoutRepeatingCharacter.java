package io.abhijith.challenges.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the Longest Substring Without Repeating Characters
 *
 * https://www.youtube.com/watch?v=4i6-9IzQHwo&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=27
 */

public class LongestSubstringWithoutRepeatingCharacter {

    public void findSolution() {

        String str = "pwwkew";
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0, max = Integer.MIN_VALUE;
        while (j < str.length()) {

            while(set.contains(str.charAt(j))) {
                set.remove(str.charAt(i));
                i++;
            }
            set.add(str.charAt(j));
            max = Math.max(max, j - i + 1);
            j++;
        }
        System.out.println(max);

    }

}
