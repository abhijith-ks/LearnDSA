package io.abhijith.java;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	
	public void findSolution() {
		
		String st = new String("Bob hit a ball, the hit BALL flew far after it was hit.");  
        
        System.out.println( Pattern.matches("[a-zA-Z0-9]+$", st) );
        
	}

}
