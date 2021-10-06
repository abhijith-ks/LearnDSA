package io.abhijith.java;

public class ThreadObject {
	
	StringBuffer sb = new StringBuffer("someValue");
	StringBuilder sb1 = new StringBuilder("nextValue");
	
	public void someFunction(int i) {
			sb.append(i + " ");
			sb1.append(i + " ");
	}

}
