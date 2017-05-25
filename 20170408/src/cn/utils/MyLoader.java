package cn.utils;

import java.io.InputStream;

/**
 * 加载一个类的过程，就是读取一个类的字节码
 * @author wangjian
 *
 */
public class MyLoader extends ClassLoader {
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> cls = null;
		try{
			InputStream in =  ClassLoader.getSystemResourceAsStream("cn/demo01/Dog.class");
			byte[] bs = new byte[in.available()];
			int len = in.read(bs);//读取所有字节
			//通过构造字节，来创建一个类的字节码
			cls = defineClass("cn.demo01.Dog", bs, 0,len);
		}catch(Exception e){
			
		}
		return cls;
	}
}
