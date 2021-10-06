package io.abhijith.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaClassReflection {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class c = Class.forName("java.lang.Math");
		Method[] m = c.getDeclaredMethods();

		for(int i = 0; i < m.length; i++) {
			System.out.println(m[i]);
		}
		
		Field[] f = c.getFields();
		
		for(int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}
	}

}
