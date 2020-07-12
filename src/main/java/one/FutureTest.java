package one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

public class FutureTest {
	
	private static class MyThread implements Callable<String>{

		public String call() throws Exception {
			Thread.sleep(2000);
			return "i'am callable";
		}
		
	}
	
	public static void main(String[] args){
		List list = new ArrayList();
		Set set = new HashSet();
		set.addAll(list);
		MyThread t = new MyThread();
		FutureTask<String> f = new FutureTask<String>(t);
//		f.run();
		new Thread(f).start();
		System.out.println("00000");
		
		try {
//			final boolean interrupted = Thread.interrupted();
			String result = f.get();
			System.out.println(result);
			System.out.println("got it,end...");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public int sdsdsd() throws InterruptedException{
		while(true){}
	}

}
