package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Practice {
	
	private static AtomicInteger ai = new AtomicInteger(10);
	private static int a = 10;
	public static class ThreadTest extends Thread{
		  public ThreadTest(String name) {
			  super(name);
		}
		@Override 
		public void run(){
			ai.compareAndSet(1, 1);
			for(int i=0;i<10;i++){
				ai.incrementAndGet();
				a++;
			}
			System.out.println(Thread.currentThread().getName()+"=="+ai.get()+"-----a="+a);
		}
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			new ThreadTest("t"+i).start();;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main end... value="+ai.get()+"------a="+a);
		
	}
}
