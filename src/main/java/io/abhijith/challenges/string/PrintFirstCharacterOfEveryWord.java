package io.abhijith.challenges.string;

/**
 * Print first character in every word
 */

public class PrintFirstCharacterOfEveryWord {

    public void findSolution() {
        String s = "Hello User!! Welcome!";

        String[] words = s.replaceAll("[^a-zA-Z]"," ").split(" ");

        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > 0)
                System.out.println(words[i].charAt(0));
        }
    }
}
