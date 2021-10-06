package io.abhijith.challenges.amazon;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
 *
 * The first word in the sequence is beginWord.
 * The last word in the sequence is endWord.
 * Only one letter is different between each adjacent pair of words in the sequence.
 * Every word in the sequence is in wordList.
 *
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord,
 * or 0 if no such sequence exists.
 *
 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 */

public class WordLadder {

    public void findSolution() {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int changes = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    System.out.println("Changes Required : " + changes);
                    return;
                }
                for (int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();
                    for (int k = 'a'; k <= 'z'; k++) {
                        charArray[j] = (char) k;
                        String str = new String(charArray);
                        if(set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            changes++;
        }
    }
}
