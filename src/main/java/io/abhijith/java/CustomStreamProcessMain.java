package io.abhijith.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomStreamProcessMain {
	
	public static void main(String[] args) {
		String[] slist = new String[] {"abhijith", "abhilash", "akhil", "abhirams", "ajay"};
		List<String> list = new ArrayList<>();
		for(String s: slist) {
			list.add(s);
		}
		String pre = "abhi";
		List<CharacterCount> cc = list
				.stream()
				.filter(getValue(pre))
				.map(mapper())
				.collect(Collectors.toList());
		
		for(CharacterCount c: cc) {
			System.out.println(c.count);
		}
	}
	
	public static Predicate<String> getValue(String pre) {
		return p -> p.substring(0, pre.length()).equals(pre);
	}
	
	public static Function<String, CharacterCount> mapper() {
		return s -> {
			CharacterCount cc = new CharacterCount();
			Set<Character> set = new HashSet<>();
			for(Character c: s.toCharArray()) {
				set.add(c);
			}
			cc.count = set.size();
			return cc;
		};
	}

}
