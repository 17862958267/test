package demo02_thread;
//�̳�Thread�����߳������ɾֲ��ڲ���
public class Demo02_FieldThread1 {
	public static void main(String[] args) {
		class One extends Thread{
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName());
			   }
			@Override
			public synchronized void start(){
				run();
			}
			}
		//�����Ϳ���ֱ�ӵ����ڲ���ķ�����������Ҫʵ������ǰ��
		One one = new One();
		one.start();
			
		}
	

}
