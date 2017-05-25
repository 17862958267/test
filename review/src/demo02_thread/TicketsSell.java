package demo02_thread;

public class TicketsSell {
	public static void main(String[] args) {
		Tickets t = new Tickets();
		Thread thread1 = new Thread(t);
		thread1.start();
		Thread thread2 = new Thread(t);
		thread2.start();
		Thread thread3 = new Thread(t);
		thread3.start();
		Thread thread4 = new Thread(t);
		thread4.start();
	}

}
class Tickets implements Runnable{

	@Override
	public void run() {
		 int tickets=30;
		 while(true){
			 if(tickets>0){
				 try{
					 Thread.sleep(1000);
					 
				 }catch(InterruptedException e){
					 e.printStackTrace();
				}
				 System.out.println(Thread.currentThread().getName()+"����������"+"��"+tickets+"��Ʊ");
				 tickets--;
				 
				 }else{
				 System.out.println("Ʊ������");
				 break;
			 }
			 
			 
			 
		 }
		
	}
	
}
