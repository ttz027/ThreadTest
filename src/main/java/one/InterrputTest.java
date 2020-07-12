package one;

/**
 * �߳��ж�
 * @author 1142632823
 *
 */
public class InterrputTest {
	
	public static class MyThread extends Thread{
		
		@Override
		public void run(){
			//�ж��߳��Ƿ��ж�
			while(!isInterrupted()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
				System.out.println("i am live...");
			}
		}
	}
	
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		try {
			t.sleep(1000);
			//�����жϱ�־
			t.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
