package demo02_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**����һ���̲߳���õ�ǰʱ�䣬Ȼ�������̵߳ĵ�������1����
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
				while(true){//��ͣ�������ǰʱ��
					String time = sdf.format(new Date());
					System.out.println("��ǰʱ�䣺"+time);
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
				
				
			
