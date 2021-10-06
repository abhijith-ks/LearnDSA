package io.abhijith.challenges.problems;

/**
 * Given an array of meeting time intervals consisting of start and end times {[s1,e1],[s2,e2]...} (si < ei)
 * Determine if a person could attend all meetings
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

import io.abhijith.resources.TimeInterval;

public class MeetingAttend {
	
	public void findSolution(TimeInterval[] ti) {
		
//		Negative case
//		ti = new TimeInterval[]{new TimeInterval(0,30),new TimeInterval(5,10), new TimeInterval(15,20)};
		
		Arrays.sort(ti, (a,b) -> a.getBeginTime() - b.getBeginTime());
		
		int endTimeVar = ti[0].getEndTime();
		
		for(int i = 1; i < ti.length; i++) {
			if(endTimeVar <= ti[i].getBeginTime()) {
				endTimeVar = ti[i].getEndTime();
			} else {
				System.out.println("Not possible");
				return;
			}
		}
		
		System.out.println("Possible to attend all meetings");
		
	}

}
