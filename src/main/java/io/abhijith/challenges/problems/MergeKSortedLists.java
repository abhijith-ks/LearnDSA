package io.abhijith.challenges.problems;

/**
 * Merge K sorted linked lists and return it as one sorted list.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	List<List<Integer>> lists = new ArrayList<>();

	public void findSolution() {
		
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.addAll(Arrays.asList(new Integer[] {1,4,5}));
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.addAll(Arrays.asList(new Integer[] {1,3,4}));
		ArrayList<Integer> a3 = new ArrayList<>();
		a3.addAll(Arrays.asList(new Integer[] {2,6}));
		
		lists.add(a1);
		lists.add(a2);
		lists.add(a3);
		
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(List l: lists) {
			minHeap.addAll(l);
		}
		
		System.out.println(minHeap);
		
	}
	
}
