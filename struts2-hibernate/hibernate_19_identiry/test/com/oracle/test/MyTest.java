package com.oracle.test;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Student;
import com.oracle.util.HibernateUtil;

public class MyTest {

	
	@Test
	public void increment(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student("张三", 0, new Date());
		
		session.save(student);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	//如果服务器需要分布式部署,或者数据量较大的情况下
	//可以使用uuid作为数据的主键
	@Test
	public void uuid(){
		String temp = UUID.randomUUID().toString();
		System.out.println(temp);
		String uuid=temp.replaceAll("-", "");
		System.out.println(uuid);
	}
	
	
	
}
