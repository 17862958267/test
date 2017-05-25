package demo02_thread;
//线程声明成成员内部类，利用继承Thread类
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
