package demo02_thread;
/**���Runnable:
Thread��������Ϊһ������,��Runnable��ʵ����Ķ������������˵Ĺ���(ͨ�����췽������).
Runnable�ӿ���ֻ��һ������run����,�÷����ж�����»ᱻ���߳�ִ�еĴ���.
�����ǰ�Runnable��������󴫵ݸ�Thread�Ĺ���ʱ,
ʵ���Ͼ����ø�Threadȡ��run����,���Ǹ���Threadһ������.
 * 
 * @author xuxin
 *
 */
public class _Runnable {
	public static void main(String[] args) {
		
	
	MyThread my = new MyThread();
	Thread t = new Thread(my);
	t.start();
	}

}
class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println("����һ��ʵ����Runnable�ӿڵ��߳�");
		
	}
	
}
