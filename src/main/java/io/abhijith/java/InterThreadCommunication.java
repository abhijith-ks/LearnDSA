package io.abhijith.java;

public class InterThreadCommunication {
	
	class Q{
		boolean valueSet = false;
		int num;
		public synchronized void set(int num) {
			while(valueSet) {
				try { wait(); } catch(InterruptedException e) {}
			}
			System.out.println("Put : " + num);
			this.num = num;
			valueSet = true;
			notify();
		}
		public synchronized void get() {
			while(!valueSet) {
				try { wait(); } catch(InterruptedException e) {}
			}
			System.out.println("Get : " + num);
			valueSet = false;
			notify();
		}
	}
	
	class Producer implements Runnable{
		Q q;
		Producer(Q q){
			this.q = q;
			Thread t1 = new Thread(this,"Producer");
			t1.start();
		}
		public void run() {
			int i = 0;
			while(true) {
				q.set(i++);
				try { Thread.sleep(500); } catch(InterruptedException e) {}
			}
		}
	}
	
	class Consumer implements Runnable{
		Q q;
		Consumer(Q q){
			this.q = q;
			Thread t2 = new Thread(this, "Consumer");
			t2.start();
		}
		public void run() {
			while(true) {
				q.get();
				try { Thread.sleep(500); } catch(InterruptedException e) {}
			}
		}
	}

	public static void main(String[] args) {
		InterThreadCommunication i = new InterThreadCommunication();
		Q q = i.new Q();
		Producer p = i.new Producer(q);
		Consumer c = i.new Consumer(q);
	}

}
