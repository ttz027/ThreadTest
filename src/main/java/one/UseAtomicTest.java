package one;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 使用带版本号的原子类
 * @author 1142632823
 *
 */
public class UseAtomicTest {

	static AtomicStampedReference<String> asr = 
			new AtomicStampedReference<String>("initValue", 0);
	public static void main(String[] args) {
		
		int initStamp = asr.getStamp();//版本号
		String initValue = asr.getReference();//初识值
		//进行比较替换：原值和原版本号必须都相同
		boolean fig = asr.compareAndSet("initValue", "newValue", 0, 1);
		System.out.println(fig);
		
		boolean fig2 = asr.compareAndSet("newValue", "newValue2", 1, 2);
		System.out.println(fig2);
		
		
	}
}
