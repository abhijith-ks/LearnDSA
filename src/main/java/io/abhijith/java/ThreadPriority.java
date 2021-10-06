package io.abhijith.java;

public class ThreadPriority extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadObject to = new ThreadObject();
		
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 1000; i++) {
					to.someFunction(i);
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 1000; i++) {
					to.someFunction(i);
				}
			}
		};
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(to.sb);
		System.out.println(to.sb1);
	}
	
}


/*
someValueappendedValue
someValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValueappendedValueappendedValue
someValueappendedValue
someValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValueappendedValue
someValueappendedValueappendedValueappendedValueappendedValueappendedValue

 */
