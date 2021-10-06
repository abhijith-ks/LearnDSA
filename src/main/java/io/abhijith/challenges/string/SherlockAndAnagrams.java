package io.abhijith.challenges.string;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. 
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 * 
 * For example s = mom, the list of all anagrammatic pairs is [m,m],[mo,om] at positions [[0][2],[0][1],[1][2]] respectively.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagrams {
	
	String s = "cdcd";
	
	public void findSolution() {
		
		List<String> list = new ArrayList<>();
        int counter = 0;

        for(int i = 1; i < s.length(); i++) {
        	
            for(int j = 0; j < s.length() + 1 - i; j++) {
                char[] x = s.substring(j, j+i).toCharArray();
                Arrays.sort(x);
                list.add(String.valueOf(x));
            }
            
            for(int j = 0; j < list.size(); j++) {
                for(int k = j + 1; k < list.size(); k++) {
                    if(list.get(j).equals(list.get(k))){
                        counter++;
                    }
                }
            }
            list.clear();
            
        }
        
        System.out.println(counter);
		
	}

}
