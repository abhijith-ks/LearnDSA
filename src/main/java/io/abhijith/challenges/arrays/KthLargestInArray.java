package io.abhijith.challenges.arrays;

/**
 * Find the K-th largest element in an unsorted array.
 * Note that it is the K-th largest element in the sorted order, not the distinct element
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestInArray {
	
	public void findSolution(int nums[], int key) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
		
		for(int i: nums) {
			maxHeap.add(i);
		}
		int x = 0;
		for(int i = 0; i < key; i++) {
			x = maxHeap.remove();
		}
		System.out.println(x);
		
		
		
//		Another Method
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i: nums) {
			minHeap.add(i);
			if(minHeap.size() > key) {
				minHeap.remove();
			}
		}
		System.out.println(minHeap.remove());
		
		
		
//		O(nlogn) solution
//		Arrays.sort(nums);
//		System.out.println(nums[nums.length - key]);
		
	}

}
