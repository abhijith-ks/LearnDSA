package io.abhijith.challenges.string;

/**
 * Given an array of strings, group anagrams together
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupedAnagrams {
	
	String[] list = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
	
	public void findSolution() {
		
		HashMap<String, List<String>> hmap = new HashMap<>();
		
		for(String s: list) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String val = new String(temp);
			if(!hmap.containsKey(val)) {
				hmap.put(val, new ArrayList<>());
			}
			hmap.get(val).add(s);
		}
		
		for(String s: hmap.keySet()) {
			System.out.println(hmap.get(s));
		}
		
		
		
//		HashMap<Integer, String> hmap = new HashMap<>();
//		for(int i = 0; i < list.length; i++) {
//			hmap.put(i, list[i]);
//			char[] temp = list[i].toCharArray();
//			Arrays.sort(temp);
//			list[i] = String.valueOf(temp);
//		}
//		
//		for(int i = 0; i < list.length; i++) {
//			List<String> temp = new ArrayList<String>();
//			if(list[i] == null)
//				continue;
//			temp.add(hmap.get(i));
//			for(int j = i+1; j < list.length; j++) {
//				if(list[i].equals(list[j])) {
//					temp.add(hmap.get(j));
//					list[j] = null;
//				}
//			}
//			list[i] = null;
//			System.out.println(temp);
//		}
	}

}
