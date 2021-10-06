package io.abhijith.challenges.amazon;

import java.util.*;

/**
 * Insert Delete GetRandom O(1) time complexity
 */

public class InsertDeleteGetRandom {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public void findSolution() {
        System.out.println(insert(1));
        System.out.println(insert(2));
        System.out.println(getRandom());
        System.out.println(remove(1));
        System.out.println(remove(2));
    }

    public boolean insert(int value) {
        if(map.containsKey(value)) {
            return false;
        }
        map.put(value, list.size());
        list.add(value);
        return true;
    }

    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }

    public boolean remove(int value) {

        if(!map.containsKey(value)) {
            return false;
        }

        int index = map.get(value);
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        map.replace(lastValue, index);
        map.remove(value);
        list.remove(list.size() - 1);

        return true;
    }

}
