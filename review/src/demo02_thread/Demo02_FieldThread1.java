package demo02_thread;
//继承Thread，将线程声明成局部内部类
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
		//这样就可以直接调用内部类的方法，而不需要实例化当前类
		One one = new One();
		one.start();
			
		}
	

}
