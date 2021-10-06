package io.abhijith.java;

public class ClassLoader {

	public static void main(String[] args) {
		
		// ClassLoader example
		Class c = ClassLoader.class;
		System.out.println(c.getClassLoader());
		System.out.println(String.class.getClassLoader());

	}

}
