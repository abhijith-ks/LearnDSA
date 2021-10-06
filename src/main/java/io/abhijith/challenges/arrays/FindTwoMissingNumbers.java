package io.abhijith.challenges.arrays;

/**
 * Given an array containing n distinct numbers taken from 1,2...n
 * Find out the two numbers that are missing from the array
 * 
 * @author abhijith-ks
 *
 */

public class FindTwoMissingNumbers {

	public void findSolution(int a[]) {
				
//		Solution with space complexity O(1) and linear time complexity
		System.out.println("Solution with space complexity O(1) and linear time complexity");
		int n = a.length + 2;
		int sum = 0, expectedSum, avg, firstHalfSum = 0, secondHalfSum = 0 ;
		
		expectedSum = (n * ( n+1 )) / 2;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		avg = (expectedSum - sum) / 2;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] <= avg) {
				firstHalfSum += a[i];
			} else {
				secondHalfSum += a[i];
			}
		}
		int totalSmallerHalf = (avg * (avg + 1)) / 2;
		System.out.println(totalSmallerHalf - firstHalfSum + " " + ((expectedSum - sum) - (totalSmallerHalf - firstHalfSum)));
		
		
//		Solution with space complexity O(n) and linear time complexity
		System.out.println("Solution with space complexity O(n) and linear time complexity");
		boolean[] b = new boolean[a.length + 3];
		
		for(int i = 0; i < a.length; i++) {
			b[a[i]] = true;
		}
		
		for(int i = 1; i < a.length + 3; i++) {
			if(!b[i]) {
				System.out.print(i + " ");
			}
		}
		
		
	}
	
}
