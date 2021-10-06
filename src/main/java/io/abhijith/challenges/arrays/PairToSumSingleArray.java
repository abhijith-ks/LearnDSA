package io.abhijith.challenges.arrays;

/**
 * Given a list of numbers and a number key
 * Return whether any two numbers from the list add up to key
 * Do this in one pass
 * O(nlogn)
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairToSumSingleArray {
	
	public void findSolution(int a[], int key) {
		
		int[] sortedA = new int[a.length];
		sortedA = Arrays.copyOf(a, a.length);
		Arrays.sort(sortedA);
		
		int i = sortedA.length-1, j=0;
		while(j < sortedA.length && i >= 0) {
			if (sortedA[i]+sortedA[j] == key) {
				System.out.println("{ "+ sortedA[i] + " , " + sortedA[j] + " }");
				return;
			}
			else if (sortedA[i]+sortedA[j] > key) {
				i--;
			}
			else {
				j++;
			}
		}
		System.out.println("Pair not exists!");
		
		

		
		/* Using Hashmap 
		Map<Integer, Integer> hmap = new HashMap<>();
		for(int i=0; i<a.length; i++) {
			hmap.put(a[i], i);
		}
		int keyValue;
		for(int i=0; i<a.length; i++) {
			keyValue = key  - a[i];
			if(hmap.containsKey(keyValue)) {
				System.out.println("{ " + a[i] + " , " + keyValue + " }");
				return;
			}
		}
		*/
	}
	
}
