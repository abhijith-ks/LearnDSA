package io.abhijith.challenges.problems;

/**
 * Given a limit n,
 * Count the prime number from 1 to n-1
 * 
 * @author abhijith-ks
 */

public class CountPrimes {
	
	int n = 10;
	
	public void findSolution() {
		
		int counter = 0;
		boolean flag = true;
		for(int i = 2; i < n; i++) {
			flag = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				counter++;
			}
			
		}
		
		System.out.println(counter);
		
	}

}
