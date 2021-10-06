package io.abhijith.challenges.dp;

import java.util.Arrays;

/**
 * Given certain jobs with start and end time and amount you make on finishing the job,
 * find the maximum value you can make by scheduling jobs in non-overlapping way.
 *
 * https://www.youtube.com/watch?v=cr6Ip0J9izc&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=17
 */

public class WeightedJobScheduling {

    class Item {
        int start;
        int end;
        int weight;

        Item(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public String toString() {
            return "start : " + start + "\tend: " + end + "\tweight: " + weight;
        }
    }

    public void findSolution() {

        Item[] items = {
                new Item(2, 5, 6),
                new Item(6, 7, 4),
                new Item(7, 9, 2),
                new Item(1, 3, 5),
                new Item(4, 6, 5),
                new Item(5, 8, 11)
        };

        Arrays.sort(items, (a,b) -> {
           return a.end - b.end;
        });

        int[] dp = new int[items.length];
        for(int i = 0; i < items.length; i++) {
            dp[i] = items[i].weight;
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i = 1; i < items.length; i++) {
            for(int j = 0; j < i; j++) {
                if(items[j].end <= items[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + items[i].weight);
                    maxValue = Math.max(maxValue, dp[i]);
                }
            }
        }

        System.out.println(maxValue);

    }

}
