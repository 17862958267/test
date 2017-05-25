package demo02_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**创建一个线程并获得当前时间，然后利用线程的调度休眠1秒钟
 * 
 * @author Administrator
 *
 */
public class _Sleep {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat();
				while(true){//不停的输出当前时间
					String time = sdf.format(new Date());
					System.out.println("当前时间："+time);
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
						
					}
				}
			
			}
		};t1.start();
	}
}
				
				
			
