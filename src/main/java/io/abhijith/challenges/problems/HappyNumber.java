package io.abhijith.challenges.problems;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers
 * 
 * @author abhijith-ks
 */

import java.util.HashSet;

public class HappyNumber {
	
	int num = 19;
	
	public void findSolution() {
		
		HashSet<Integer> set = new HashSet<>();
		set.add(num);

		while(true) {
			
			int sum = 0;
			while(num != 0) {
				int temp = num % 10;
				sum += (temp * temp);
				num /= 10;
			}
			if(sum == 1) {
				System.out.println(true);
				break;
			}
			if(set.contains(sum)) {
				System.out.println(false);
				break;
			}
			set.add(sum);
			num = sum;
		}
		
	}

}
