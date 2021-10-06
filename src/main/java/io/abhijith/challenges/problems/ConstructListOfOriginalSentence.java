package io.abhijith.challenges.problems;

/**
 * Given a dictionary of words and a string made up of those words(no spaces)
 * return the original sentence in a list.
 * If there is more than on possible reconstruction, return any of them
 * 
 * Example: Given the set of words ['quick','brown','the','fox'] and string "thequickbrownfox"
 * you should return ['the','quick','brown','fox']
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;

public class ConstructListOfOriginalSentence {
	
	ArrayList<String> list = new ArrayList<>();
	ArrayList<String> listCopy = new ArrayList<>();


//	sentence = thequickbrownfox
	public void findSolution(String sentence) {
		
		list.add("quick");
		list.add("brown");
		list.add("the");
		list.add("fox");
		
		String temp= "";
		
		for(int i=0;i<sentence.length();i++) {
			temp += sentence.charAt(i);
			if(list.contains(temp)) {
				listCopy.add(temp);
				temp = "";
			}
		}
		
		System.out.println(listCopy);
		
	}
	
}
