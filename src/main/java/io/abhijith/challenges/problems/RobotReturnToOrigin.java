package io.abhijith.challenges.problems;

/**
 * There is a robot starting at position (0,), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0,0) after it completes its moves.
 * 
 * The move sequence is represented by a string, where each character denotes a move.
 * Valid moves are R, L, U, D
 * 
 * The way the robot face is irrelevant
 * 
 * @author abhijith-ks
 *
 */

public class RobotReturnToOrigin {
	
	public void findSolution(String s) {
		
		
		int ud = 0, lr = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'U')
				ud++;
			else if(s.charAt(i) == 'D')
				ud--;
			else if(s.charAt(i) == 'L')
				lr++;
			else if(s.charAt(i) == 'R')
				lr--;
		}
		
		System.out.println(lr == 0 && ud == 0);
		
	}

}
