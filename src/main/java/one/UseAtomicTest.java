package one;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ʹ�ô��汾�ŵ�ԭ����
 * @author 1142632823
 *
 */
public class UseAtomicTest {

	static AtomicStampedReference<String> asr = 
			new AtomicStampedReference<String>("initValue", 0);
	public static void main(String[] args) {
		
		int initStamp = asr.getStamp();//�汾��
		String initValue = asr.getReference();//��ʶֵ
		//���бȽ��滻��ԭֵ��ԭ�汾�ű��붼��ͬ
		boolean fig = asr.compareAndSet("initValue", "newValue", 0, 1);
		System.out.println(fig);
		
		boolean fig2 = asr.compareAndSet("newValue", "newValue2", 1, 2);
		System.out.println(fig2);
		
		
	}
}
