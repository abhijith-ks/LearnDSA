package io.abhijith.challenges.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Reverse Vowels In A String
 */

public class ReverseVowelsOfString {

    public void findSolution() {

        String input = "Applepie";
//        String input = "hello";
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int i = 0, j = input.length() - 1;
        char[] charArray = input.toCharArray();

        while (i < j) {
            if (vowelSet.contains(Character.toLowerCase(charArray[i])) && vowelSet.contains(Character.toLowerCase(charArray[j]))) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            } else {
                if (vowelSet.contains(Character.toLowerCase(charArray[i]))) {
                    i--;
                }
                if (vowelSet.contains((Character.toLowerCase(charArray[j])))) {
                    j++;
                }
            }
            i++;
            j--;
        }

        System.out.println(new String(charArray));
    }

}
