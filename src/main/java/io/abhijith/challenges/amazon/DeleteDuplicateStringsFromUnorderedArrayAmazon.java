package io.abhijith.challenges.amazon;

import java.util.*;

/**
 * Given a list of strings (IP v4 addresses).
 * How to remove duplicates from the list.
 * We can add them to a hash set or order them and use 2 pointers to remove duplicates.
 * Can we do it without an additional memory or sorting?
 */

public class DeleteDuplicateStringsFromUnorderedArrayAmazon {

    public void findSolution() {

        String[]  list = {"12","11","12","21","41","43","21"};

        Set<String> returnList = usingLinkedHashSet(Arrays.asList(list));
        for (String s: returnList) {
            System.out.print("\t" + s);
        }
        System.out.println();

        String[] returnArray = usingStream(list);
        for(String val: returnArray) {
            System.out.print("\t" + val);
        }
        System.out.println();

        int length = list.length;

        int z = 0;
        while (z < length) {
            String value = list[z];
            int i = z + 1;
            while (i < length) {
                if(list[i].equals(value)) {
                    for(int k = i + 1; k < length; k++) {
                        list[ k - 1] = list[k];
                    }
                    length--;
                } else {
                    i++;
                }
            }
            z++;
        }
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print("\t" + list[i]);
        }
    }

    public String[] usingStream(String[] input) {
        Object[] result = Arrays.stream(input).distinct().toArray();
        String[] stringResult = new String[result.length];
        for (int i = 0; i < stringResult.length; i++) {
            stringResult[i] = (String) result[i];
        }
        return stringResult;
    }

    public Set<String> usingLinkedHashSet(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        return set;
    }


}
