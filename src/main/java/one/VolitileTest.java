package one;

import one.InterrputTest.MyThread;

public class VolitileTest {
	private static volatile int age = 10;
	
	public static class MyThread extends Thread{
		
		@Override
		public void run(){
			//判断线程是否被中断
			while(true){ 
			age++;
			System.out.println("t1："+age);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	public static class MyThread2 extends Thread{
			@Override
			public void run(){ 
				while(true){
					System.out.println("t2："+age); 
				}
			}
		}

	public static void main(String[] args) {
		MyThread t = new MyThread();
		MyThread2 t2 = new MyThread2();
		t.setDaemon(true);
		t2.setDaemon(true);
		t.start();
		t2.start();
		try {
			t.sleep(200);
			//设置中断标志
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
