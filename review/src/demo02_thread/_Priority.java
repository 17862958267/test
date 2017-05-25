package demo02_thread;

public class _Priority {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=1;i<3;i++){
					System.out.println("i is:"+i);
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int j=1;j<3;j++){
					System.out.println("j is :"+j);
				}
				
			}
			
		});
		t1.setPriority(Thread.MAX_PRIORITY);//设置优先级
		t2.setPriority(Thread.MIN_PRIORITY);//越小越先调度
		t1.start();
		t2.start();
		
	}

}
