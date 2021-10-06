package io.abhijith.challenges.problems;

/**
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * (It is guaranteed that each person can be carried by a boat.
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class BoatsToSavePeople {
	
	int[] a = new int[] {3,2,2,1};
	int limit = 3;
	int counter = 0;
	
	public void findSolution() {
		
		if(a.length == 0 || a == null) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(a);
		int i = 0, index = a.length - 1;
		
		while(i <= index) {
			if(a[i] + a[index] <= limit) {
				i++;
				index--;
			}
			else {
				index--;
			}
			counter++;
		}
		System.out.println(counter);
		
	}

}
