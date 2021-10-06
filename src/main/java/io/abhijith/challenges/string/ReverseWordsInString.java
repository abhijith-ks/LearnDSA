package io.abhijith.challenges.string;

/**
 * Reverse words in the string
 * Example:
 *      Input: Life finds a way
 *      Output: way a finds Life
 */

public class ReverseWordsInString {

    public void findSolution() {
        String str = "Life finds a way";
        String[] words = str.split(" ");
        StringBuffer finalString = new StringBuffer();

        for(int i = words.length - 1; i >= 0; i--) {
            finalString.append(words[i]).append(" ");
        }

        System.out.println(finalString.delete(finalString.length() - 1, finalString.length()));
    }

}
