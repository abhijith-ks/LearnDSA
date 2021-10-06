package io.abhijith.challenges.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Find longest substring with K distinct characters
 * Example:
 *      String: bccbababd
 *      K: 2
 * Longest substring with 2 distinct characters: babab
 */

public class LongestSubstringWithKDistinctCharacters {

    public void findSolution() {

        String s = "bccbababd";
        int k = 2;

        int tempK = k;

        Set<Character> characters = new HashSet<>();

        int i = 0, j = 0;
        String current = "";
        String substring = "";

        while(j < s.length()) {
            if(characters.contains(s.charAt(j))) {
                current += s.charAt(j);
                j++;
            } else if(tempK != 0){
                tempK--;
                characters.add(s.charAt(j));
                current += s.charAt(j);
                j++;
            } else {
                if(current.length() > substring.length()) {
                    substring = current;
                }
                j = i + 1;
                i++;
                current = "";
                tempK = k;
//                characters = new HashSet<>();
                characters.clear();
            }
        }

        System.out.println(substring);
    }

}
