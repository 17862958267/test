package demo02_thread;
//�߳������ɳ�Ա�ڲ��࣬���ü̳�Thread��
public class Demo02_FieldThread {
	class One extends Thread{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().toString());
		}
		
	}
	public static void main(String[] args) {
		Demo02_FieldThread demo02 = new Demo02_FieldThread();
		One one = demo02.new One();
		one.start();
	}

}
