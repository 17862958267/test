package com.oracle.test;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Student;
import com.oracle.util.HibernateUtil;

public class MyTest {

	/*
	 * 同步点:
	 * 	只有一个: 提交事务时
	 * 	当程序执行到同步点时,所有session管理的数据将被同步到数据库
	 * 
	 * 刷新点:
	 * 	有3个:   Query查询时
	 * 			session.flush()时
	 * 			事务提交时
	 * 
	 *  当程序执行到刷新点,会立即执行所有待执行的sql语句,并从数据库中查询内容
	 *  查询出来的内容不包括脏数据(事务级别不为read uncommitted)
	 *  
	 *  
	 * */
	
	
	//同步操作
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student("李四",20,new Date());
		session.save(student);
		
		session.getTransaction().commit();
		
		session.close();
	}
	//同步操作
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		//当提交事务时,session管理的所有数据都会被同步到数据库
		Student student=(Student) session.get(Student.class, "4028abd05dabfc80015dabfc81fe0000");
		
		student.setName("abcdefg");
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	public void test3(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student();
		student.setUuid("4028abd05dabfc80015dabfc81fe0000");
		session.delete(student);
		
		session.createQuery("from Student").list();
		
		
		//session.getTransaction().commit();
		
		session.close();
	}
	@Test
	public void test4(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student();
		
		session.save(student);
		
		session.createQuery("from Student").list();
		
		//session.getTransaction().commit();
		
		session.close();
	}
	
	
	
	@Test
	public void test5(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student();
		student.setUuid("4028abd05dabfc80015dabfc81fe0000");
		session.update(student);
		
		session.createQuery("from Student").list();
		
		//session.getTransaction().commit();
		
		session.close();
	}
	@Test
	public void test6(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		
		Student student=(Student) session.get(Student.class, "4028abd05dabfc80015dabfc81fe0000");
		
		//session.createQuery("from Student").list();
		
		//session.getTransaction().commit();
		
		session.close();
	}
	@Test
	public void test7(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student=new Student();
		student.setUuid("4028abd05dabfc80015dabfc81fe0000");
		session.update(student);
		
		session.flush();
		
		//session.getTransaction().commit();
		
		session.close();
	}
}
