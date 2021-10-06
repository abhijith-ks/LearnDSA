package io.abhijith.challenges.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the powerset of a given set
 */

public class Powerset {

    public void findSolution() {
        int[] set = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        powerSet(set, 0, new ArrayList<>(), result);
        for (List<Integer> list : result) {
            System.out.print("\t" + list);
        }
    }

    public void powerSet(int[] set, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == set.length) {
            result.add(current);
            return;
        }
        List<Integer> newList = new ArrayList<>(current);
        current.add(set[index]);
        powerSet(set, index + 1, current, result);
        powerSet(set, index + 1, newList, result);
    }

}
