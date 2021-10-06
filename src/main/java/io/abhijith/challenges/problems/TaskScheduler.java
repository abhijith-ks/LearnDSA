package io.abhijith.challenges.problems;

/**
 * Given a char array representing tasks CPU need to do. 
 * It contains capital letters A to Z where different letters represent different tasks. 
 * Tasks could be done without original order. Each task could be done in one interval. 
 * For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two same tasks, 
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	public void findSolution(char[] arr, int n) {
		
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(char c: arr) {
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		maxHeap.addAll(hmap.values());
		
		int cycles = 0;
		
		while(!maxHeap.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i <= n; i++) {
				if(!maxHeap.isEmpty())
					temp.add(maxHeap.remove());
			}
			for(int i: temp) {
				if(--i != 0) {
					maxHeap.add(i);
				}
			}
			
			cycles += (!maxHeap.isEmpty()) ? n + 1 : temp.size();
			
		}
		
		System.out.println(cycles);
		
	}

}
