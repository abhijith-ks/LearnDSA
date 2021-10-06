package io.abhijith.challenges.arrays;

/**
 * A peak element is an element which is higher than its neighbors
 * Given an input array nums, where nums[i] != nums[i+1], find a peak element and return its index.
 * Array can contain multiple peaks, in that case return any of the peaks
 * Solution should be in log(n) complexity
 * 
 * Example for use case of Binary Search
 * 
 * @author abhijith-ks
 *
 */

public class FindPeakElement {
	
	public void findSolution(int a[]) {
		a = new int[] {1,2,3,1};
		
		int left = 0;
		int right = a.length - 1;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(a[mid] < a[mid+1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		System.out.println(left);
		
//		int peak = 0;
//		
//		for(int i = 1; i < a.length-1; i++) {
//			if(a[i] > a[i-1] && a[i] > a[i+1]) {
//				peak = i;
//				break;
//			}
//		}
//		
//		System.out.println(peak);
		
	}
}
