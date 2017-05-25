package cn.demo01;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.utils.MyLoader;

public class Demo02 {
	@Test
	public void test1() {
		ClassLoader cl1 = String.class.getClassLoader();
		ClassLoader cl2 = System.class.getClassLoader();
		System.err.println(cl1 + "," + cl2);// null,null
	}

	@Test
	public void test2() {
		// 使用类加载 器直接读取claspath下的文件
		URL url = ClassLoader.getSystemResource("c3p0-config.xml");
		// url is:/D:/programfiles/eclipse_wk/qlu/20170408/bin/c3p0-config.xml
		System.err.println("url is:" + url.getPath());
		File file = new File(url.getPath());
		System.err.println(file.exists());
	}

	@Test
	public void test3() throws Exception {
		Class<?> cls = new MyLoader().findClass("");
		Object obj = cls.newInstance();
		System.err.println(obj);
		System.err.println(cls.getClassLoader());

		Dog dog = (Dog) obj;
		System.err.println("dog..." + dog);
	}

	@Test
	public void test4() throws Exception{
		//1:声明被代理的类
		final ArrayList<String> list = new ArrayList<>();
		//2创建List的代理
		Object proxyObj = 
				Proxy.newProxyInstance(Demo02.class.getClassLoader(), new Class[]{List.class},new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.err.println("目前执行的代理的："+method.getName());
						if(method.getName().equals("add")){
							if(args[0].equals("Jack")){
								System.err.println("不能添加Jack");
								return false;
							}
						}
						//否则继续执行
						return method.invoke(list,args);
					}
				});
		//将
		
		java.util.List<String> list2 = (java.util.List<String>) proxyObj;
		
		list2.add("Mary");
		System.err.println(list.size());//1
		list2.add("Jack");
		System.err.println(list.size());//1
		
		list.add("Jack");
		System.err.println(list2.size());//2
	}
}
