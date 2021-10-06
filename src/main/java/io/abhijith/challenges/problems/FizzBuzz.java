package io.abhijith.challenges.problems;

/**
 * FizzBuzz
 * --------
 * Accepts upper limit.
 * Print 1 to n in new line
 * For each multiple of 3 print "Fizz"
 * For each multiple of 5 print "Buzz"
 * For numbers which are multiple of 3 and 5, print "FizzBuzz"
 * @author abhijith-ks
 *
 */

public class FizzBuzz {
	
	public void findSolution(int n) {
		
		for(int i=1; i<=n; i++) {
			
			String output = "";
			output += (i%3 == 0) ? "Fizz" : "";
			output += (i%5 == 0) ? "Buzz" : "";
			if(output.length()==0)
				output = i + "";
			System.out.println(output);	
			
			/* Another way to solve the problem
			if(i%3==0 && i%5==0) {
				System.out.println("FizzBuzz");
				continue;
			}
			if(i%3 == 0) {
				System.out.println("Fizz");
				continue;
			}
			if(i%5 == 0) {
				System.out.println("Buzz");
				continue;
			}
			System.out.println(i); 
			*/
		}
		
	}

}
