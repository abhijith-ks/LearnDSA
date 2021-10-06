package io.abhijith.challenges.string;

/**
 * Reverse individual words in a sentence
 * Example:
 *      Input: Life finds a way
 *      Output: efiL sdnif a yaw
 */

public class ReverseIndividualWordsInSentence {

    public void findSolution() {

        String sentence = "Life finds a way";

        String[] stringList = sentence.split(" ");
        StringBuffer finalString = new StringBuffer("");

        for (int i = 0; i < stringList.length; i++) {
            finalString.append(reverseString(stringList[i])).append(" ");
        }

        finalString.delete(finalString.length() - 1, finalString.length());
        System.out.println(finalString);
    }

    public String reverseString(String str) {

        int i = 0, j = str.length() - 1;
        char[] charArray = str.toCharArray();

        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++; j--;
        }

        return String.valueOf(charArray);
    }

}
