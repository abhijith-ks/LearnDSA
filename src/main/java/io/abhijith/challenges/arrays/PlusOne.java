package io.abhijith.challenges.arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, do plus one to the integer
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit
 * You may assume that the integer does not contain any leading zero except for the number zero itself
 * 
 * @author abhijith-ks
 *
 */

public class PlusOne {
	
	public void findSolution(int num[]) {
		
		int i = num.length-1, flag = 0;
		while(i >= 0) {
			if(num[i] < 9) {
				num[i]++;
				flag = 1;
				break;
			}
			
			num[i] = 0;
			
			i--;
		}
		
		if(flag == 0) {
			int[] newArr = new int[num.length + 1];
			newArr[0] = 1;
			
			for(int number: newArr) {
				System.out.print(number + " ");
			}
			
		} else {
			for(int number: num) {
				System.out.print(number + " ");
			}
		}
		
	}
	
}
