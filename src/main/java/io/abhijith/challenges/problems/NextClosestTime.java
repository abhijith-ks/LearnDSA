package io.abhijith.challenges.problems;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * 
 * You may assume the given input string is always valid
 * 
 * @author abhijith-ks
 */

import java.util.HashSet;

public class NextClosestTime {
	
	String time = "19:34";
	
	public void findSolution() {
	
		int minutes = Integer.parseInt(time.substring(0,2)) * 60;
		minutes += Integer.parseInt(time.substring(3));
		
		HashSet<Integer> set = new HashSet<>();
		for(char c: time.toCharArray()) {
			set.add(c - '0');
		}
		
		while(true) {
			minutes = (minutes + 1) % (24 * 60);
			Integer[] current = {minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};
			
			boolean flag = true;
			for(Integer i: current) {
				if(!set.contains(i)) {
					flag = false;
				}
			}
			if(flag) {
				System.out.println(minutes / 60 + ":"+ minutes % 60);
				break;
			}
		}
		
	}

}
