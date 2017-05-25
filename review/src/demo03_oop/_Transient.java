package demo03_oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**transient�ؼ���ʹ���ܽ᣺
 * ĳ��������Բ���Ҫ�����л�������һЩ������Ϣ������ȣ�����Ϣ�ı�����ǰ���������ؼ��־Ϳ���
 * ���л�����ʱ��������ԾͲ��ᱻ���л���Ŀ�ĵ���
 * һ����ֻҪʵ����Serializable�ӿڣ������������뷽�����ᱻ   �Զ����л���
 * ��ȻҲ����ʵ��Externalizable�ӿڣ���������಻�ᱻ�Զ����л�����Ҫ��writeExternal�����У��ֶ�ָ��
 * Ҫ���л��ı�����
 * @author Administrator
 *
 */
public class _Transient implements Serializable {
	public static void main(String[] args) {
	        User user = new User();
	        user.setName("Jack");
	        user.setPasswd("1234");
	        System.out.println("read before Serializable"+"\t\n"+user.getName()+"\t\n"+user.getPasswd());
	
	      //��ȡ�����
	        try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/a/a.txt"));
			    out.writeObject(user);
			    out.flush();
			    out.close();
	        
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        
	        try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:/a/a.txt"));
			    try {
					user = (User) in.readObject();
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			    in.close(); 
			    System.out.println("read after Serializable");
			    System.out.println(user.getName());
			    System.out.println(user.getPasswd());
			    
	        
	        
	        } catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	
	
	
	}

}
