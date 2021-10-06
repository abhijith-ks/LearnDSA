package io.abhijith.challenges.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 */

public class ReorganizeString {

    public void findSolution() {
        String s1 = "aab";
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            counts.put(s1.charAt(i), counts.getOrDefault(s1.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            return counts.get(b) - counts.get(a);
        });
        maxHeap.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(current) > 0) {
                maxHeap.add(current);
            }
            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }
        if (maxHeap.size() != 0) {
            char item = maxHeap.remove();
            if (counts.get(item) > 1) {
                System.out.println("");
                return;
            }
            result.append(item);
        }
        System.out.println(result);
    }

}
