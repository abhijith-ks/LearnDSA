package io.abhijith.challenges.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * https://www.youtube.com/watch?v=cupg2TGIkyM&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=19
 */

public class TopKFrequentWords {

    public void findSolution() {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        Map<String, Integer> frequenctMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            frequenctMap.put(words[i], frequenctMap.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<String>((a,b) -> {
            if(frequenctMap.get(a) == frequenctMap.get(b)) {
                return b.compareTo(a);
            } else {
                return frequenctMap.get(a) - frequenctMap.get(b);
            }
        });

        frequenctMap.keySet().forEach(val -> {
            minHeap.add(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        });

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }
    }

}
