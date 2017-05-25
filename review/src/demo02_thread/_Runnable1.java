package demo02_thread;

public class _Runnable1 {
	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("我是实现Runnable接口的线程的另一种表达方式");
				
			}
			
		});
		t1.start();
	}

}
