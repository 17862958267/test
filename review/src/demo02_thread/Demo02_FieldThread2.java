package demo02_thread;

public class Demo02_FieldThread2 {
	public static void main(String[] args) {
	Thread t1= new Thread(){
    	 @Override
    	 public void run(){
    		 System.out.println("hi");
    	 }
     };
     t1.start();
     new Thread(){
    	 public void run(){
    		System.out.println("hi1"); 
    	 }
    	 
     }.start();
}
}