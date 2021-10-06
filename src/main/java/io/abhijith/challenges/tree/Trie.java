package io.abhijith.challenges.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Trie data structure for word search
 * Operations
 *  1. Add Word
 *  2. Search Word
 *  3. Suggestions for Prefix
 */

public class Trie {

    static class WordTrie {
        boolean isCompleteWord;
        WordTrie[] children = new WordTrie[26];
        WordTrie() {
            isCompleteWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    WordTrie root;

    public void insert(String word) {

        WordTrie node = root;

        for (int i = 0; i < word.length(); i++) {
            if(node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new WordTrie();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isCompleteWord = true;
    }

    public boolean search(String word) {
        WordTrie node = root;

        for (int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);

            if(node.children[index - 'a'] == null) {
                return false;
            }
            node = node.children[index - 'a'];
        }
        return node.isCompleteWord;
    }

    public List<String> suggestions(String word) {
        WordTrie node = root;
        List<String> suggestions = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            char index = word.charAt(i);
            if(node.children[index - 'a'] == null) {
                return suggestions;
            }
            node = node.children[index - 'a'];
        }
        getCompletedWords(word, suggestions, node);
        return suggestions;
    }

    public void getCompletedWords(String prefix, List<String> suggestions, WordTrie node) {

        if(node == null) {
            return;
        }

        if(node.isCompleteWord) {
            suggestions.add(prefix);
        }

        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                String copyPrefix = prefix;
                char val = (char) ('a' + i);
                prefix = prefix + val;
                getCompletedWords(prefix, suggestions, node.children[i]);
                prefix = copyPrefix;
            }
        }
    }


    public void findSolution() {

        String[] wordList = new String[]{"the", "a", "there", "answer", "any", "by", "bye", "their", "those"};
        root = new WordTrie();

        for (String word : wordList) {
            insert(word);
        }

        System.out.println(search("the"));
        System.out.println(search("any"));
        System.out.println(search("aby"));
        System.out.println(search("answer"));
        System.out.println(search("answers"));

        List<String> suggestions  = suggestions("th");
        System.out.println("SUGGESTIONS");
        for (String s: suggestions) {
            System.out.println(s);
        }
    }

}
