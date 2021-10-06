package io.abhijith.challenges.problems;

/**
 * Implement Rabin-Karp algorithm for substring search in a text
 * O (mn) solution, With better hash function, performance increases
 */

public class RabinKarpSubstringSearch {

    String pattern = "abc";
    String text = "aabcbdcajvnabclfdnlabcksl";

    int hashPrime = 101;

    int counter = 0;

    public void findSolution() {

        if(pattern.length() > text.length()) {
            System.out.println("Text size is less than pattern size");
            return;
        }

        int patternLength = pattern.length();
        int textLength = text.length();

        int patternHash = 0;
        int textHash = 0;
        for (int i = 0; i < patternLength; i++) {
            patternHash += ((pattern.charAt(i) - 'a') + 1) * Math.pow(hashPrime, i);
            textHash += ((text.charAt(i) - 'a') + 1) * Math.pow(hashPrime, i);
        }

        if(patternHash == textHash) {
           if(checkForEquality(text, 0, patternLength)) {
               counter++;
           }
        }

        for (int i = 1; i < textLength - patternLength + 1; i++) {
            int newHash = textHash - ((text.charAt(i - 1) - 'a') + 1);
            newHash /= hashPrime;
            newHash += (((text.charAt(i + patternLength - 1) - 'a') + 1) * Math.pow(hashPrime, patternLength - 1));
            if(patternHash == newHash) {
                if (checkForEquality(text, i, i + patternLength)) {
                    counter++;
                }
            }
            textHash = newHash;
        }

        System.out.println(counter);
    }

    public boolean checkForEquality(String text, int x, int y) {
        String subStringValue = text.substring(x, y);
        return pattern.equals(subStringValue);
    }

}
