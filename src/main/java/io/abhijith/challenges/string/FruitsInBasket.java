package io.abhijith.challenges.string;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * - Add one piece of fruit from this tree to your baskets. If you cannot, stop.
 * - Move to the next tree to the right of the current tree. If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2,
 * then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 * 
 * Example:
 * Input: [0,1,2,2]
 * Output: 3
 * We can collect [1,2,2]
 * 
 * Note: Basically the problem asking us to find the longest substring consisting of two digits
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class FruitsInBasket {
	
	public void findSolution(int[] tree) {
		
		if(tree == null || tree.length == 0) {
			System.out.println(0);
			return;
		}
		
		int max = 1;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		int i = 0, j = 0;
		while(j < tree.length) {
			if(hmap.size() <= 2) {
				hmap.put(tree[j], j++);
			}
			if(hmap.size() > 2) {
				int min = tree.length - 1;
				for(int value: hmap.values()) {
					min = Math.min(min, value);
				}
				
				i = min + 1;
				hmap.remove(tree[min]);
			}
			max = Math.max(max, j - i);
		}
		
		System.out.println(max);
	}

}
