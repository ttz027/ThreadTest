package aqs;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class AQSTest implements Lock {
	
	private static class Sync extends AbstractQueuedSynchronizer{
//		��ǰ���Ƿ�ռ��
		protected boolean  isHeldExclusively(){
			return getState()==1;
		}
		
		protected boolean tryAcquire(int arg){
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true; 
			}
			return false;
		}
		
		protected boolean tryRelease(int arg){
			if(getState()==0){
				throw new UnsupportedAddressTypeException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
		Condition newCondition(){
			return new ConditionObject();
		}
		
	}

	private final Sync sycn = new Sync();
	public void lock() {
		sycn.acquire(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		sycn.acquireInterruptibly(1);
	}

	public boolean tryLock() {
		return sycn.tryAcquire(1);
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public void unlock() {
		// TODO Auto-generated method stub
		sycn.tryRelease(1);
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return sycn.newCondition();
	}
	
}
