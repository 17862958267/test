package demo02_thread;
/**理解Runnable:
Thread类可以理解为一个工人,而Runnable的实现类的对象就是这个工人的工作(通过构造方法传递).
Runnable接口中只有一个方法run方法,该方法中定义的事会被新线程执行的代码.
当我们把Runnable的子类对象传递给Thread的构造时,
实际上就是让给Thread取得run方法,就是给了Thread一项任务.
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
		System.out.println("我是一个实现了Runnable接口的线程");
		
	}
	
}
