package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示锁
 * @author 1142632823
 *
 */
public class LockTest {
	
	public static Lock lock = new ReentrantLock();
	public static Condition con = lock.newCondition();
	
	public static class Thread1 extends Thread{
		@Override 
		public void run(){
			try {
				lock.lock();
				//等待
				con.await();
				System.out.println("wait end...");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			
		}
	}
	public static class Thread2 extends Thread{
		@Override 
		public void run(){
				try {
					lock.lock();
					//通知
					con.signal();
					System.out.println("unlocked...");
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				} 
		}
	}
	
	public static void main(String[] args) {
		 Thread1 t1 = new Thread1();
		 Thread2 t2 = new Thread2();
		
		 t1.start();
		 try {
			Thread.sleep(1000);
			t2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
