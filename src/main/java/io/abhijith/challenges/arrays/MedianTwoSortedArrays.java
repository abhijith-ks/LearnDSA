package io.abhijith.challenges.arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class MedianTwoSortedArrays {
	
	public void findSolutionBest(int[] nums1, int[] nums2) {
		
		if(nums1.length > nums2.length) {
			findSolutionBest(nums2, nums1);
			return;
		}
		int x = nums1.length;
		int y = nums2.length;
		
		int low = 0, high = x;
		
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((nums1.length + nums2.length) % 2 == 0) {
					System.out.println((Integer.max(maxLeftX, maxLeftY) + Integer.min(minRightX, minRightY)) / 2.0);
				}
				else {
					System.out.println(Integer.max(maxLeftX, maxLeftY));
				}
				return;
			}
			else if(maxLeftX > minRightY) {
				high = partitionX - 1;
			}
			else {
				low = partitionX + 1;
			}
			
		}
		
		
	}

	public void findSolution(int[] nums1, int[] nums2) {
		
		nums1 = new int[] {1,3};
		nums2 = new int[] {2};
		int i, totalLength = nums1.length + nums2.length;
		double result;
		
		int[] finalArr  = new int[totalLength];
		for(i=0; i<nums1.length; i++) {
			finalArr[i] = nums1[i];
		}
		for(int j=0; j<nums2.length; j++) {
			finalArr[i] = nums2[j];
			i++;
		}
		Arrays.sort(finalArr);
		if(totalLength%2 == 0) {
			result = (finalArr[totalLength/2] + finalArr[(totalLength/2)-1] ) / 2.0;
		}
		else {
			result = finalArr[totalLength/2];
		}
		
		System.out.println(result);
	}
	
}
