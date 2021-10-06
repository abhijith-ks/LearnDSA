package io.abhijith.challenges.amazon;

import java.util.Arrays;

/**
 * You have an array of logs. Each log is a space-delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier. Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs. It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically, ignoring identifiers, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 */

public class ReorderDataInLogFiles {

    public void findSolution() {
//        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}; // [let1 art can, let3 art zero, let2 own kit dig, dig1 8 1 5 1, dig2 3 6]
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"}; // [g1 act car, a8 act zoo, ab1 off key dog, a1 9 2 3 1, zo4 4 7]

        Arrays.sort(logs, (log1, log2) -> {

            int index1 = log1.indexOf(" ");
            int index2 = log2.indexOf(" ");

            String id1 = log1.substring(0, index1);
            String id2 = log2.substring(0, index2);
            String data1 = log1.substring(index1 + 1);
            String data2 = log2.substring(index2 + 1);

            boolean isDigit1 = Character.isDigit(data1.charAt(0));
            boolean isDigit2 = Character.isDigit(data2.charAt(0));

            if(!isDigit1 && !isDigit2) {
                if(data1.compareTo(data2) == 0) {
                    return id1.compareTo(id2);
                } else {
                    return data1.compareTo(data2);
                }
            }

            return (isDigit1) ? ((isDigit2) ? 0 : 1) : -1;
        });

        for (String s : logs) {
            System.out.print("\t" +  s);
        }
    }

}
