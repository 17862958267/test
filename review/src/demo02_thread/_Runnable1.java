package demo02_thread;

public class _Runnable1 {
	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("����ʵ��Runnable�ӿڵ��̵߳���һ�ֱ�﷽ʽ");
				
			}
			
		});
		t1.start();
	}

}
