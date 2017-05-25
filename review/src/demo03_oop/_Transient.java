package demo03_oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**transient关键字使用总结：
 * 某个类的属性不需要被序列化，比如一些敏感信息，密码等，在信息的变量名前面加上这个关键字就可以
 * 序列化对象时，这个属性就不会被序列化到目的地中
 * 一个类只要实现了Serializable接口，则他的属性与方法都会被   自动序列化。
 * 当然也可以实现Externalizable接口，但是这个类不会被自动序列化，需要在writeExternal方法中，手动指定
 * 要序列化的变量。
 * @author Administrator
 *
 */
public class _Transient implements Serializable {
	public static void main(String[] args) {
	        User user = new User();
	        user.setName("Jack");
	        user.setPasswd("1234");
	        System.out.println("read before Serializable"+"\t\n"+user.getName()+"\t\n"+user.getPasswd());
	
	      //获取输出流
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
