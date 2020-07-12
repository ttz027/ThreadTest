package one;

/**
 * 守护线程
 * @author 1142632823
 *
 */
public class DaemonTest {
	
	public static class MyThread extends Thread{
		
		@Override
		public void run(){
			//判断线程是否被中断
			try {
				while(!isInterrupted()){
					 
					System.out.println("i am live...");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				System.out.println("over...");
			}
		}
	}
	
	
	public static void main(String[] args) {
		
			MyThread t = new MyThread();
			t.setDaemon(true);
			t.start();
			System.out.println("main over...");
//		 
		
	}
}
