package io.abhijith.java;

public class DeadLock {

	public static void main(String[] args) {

		final String resource1 = "resource 1";
		final String resource2 = "resource 2";
		
		Thread t1 = new Thread() {
		
			public void run() {
				synchronized(resource1) {
					System.out.println("Thread 1 has resource 1");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(resource2) {
						System.out.println("Thread 1 has resource 2");
					}

				}
			}
			
		};
		
		Thread t2 = new Thread() {
		
			public void run() {
				synchronized(resource2) {
					System.out.println("Thread 2 has resource 2");
				}
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(resource1) {
					System.out.println("Thread 2 has resource 1");
				}
			}
			
		};
		
		t1.start();
		t2.start();
	}

}
