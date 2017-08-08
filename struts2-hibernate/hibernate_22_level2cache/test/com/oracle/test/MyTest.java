package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Student;
import com.oracle.util.HibernateUtil;

public class MyTest {

	/*
	 * 一级缓存属于hibernate内置缓存,不可关闭,强制使用
	 * 
	 * hibernate一级缓存依赖于session,存活与session
	 * 在同一个session中查询到的所有数据,都会交给一级缓存去管理
	 * 只要不通过query.list()方法查询,其他的查询方式都会先在一级缓存中查询需要查询的内容
	 * 如果一级缓存找不到结果,才去数据库
	 * 
	 * 
	 * 
	 * 快照:一级缓存的表现,所有当前session查询出来的数据在一级缓存中都会以快照的形式表现
	 * 当session提交时,会检查快照与初始状态是否存在改变
	 * 如果该快照有改变,则提交事务时会出发update语句,将快照中的新内容,同步到数据库
	 * 
	 * */
	
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		
		Student student1=(Student) session.get(Student.class, "4028abd05dabfc80015dabfc81fe0000");
		
		Student student2=(Student) session.get(Student.class, "4028abd05dabfc80015dabfc81fe0000");
		
		
		
		
		session.close();
	}
	
	
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Student student1=(Student) session.get(Student.class, "4028abd05dabfc80015dabfc81fe0000");
		
		student1.setName("黑猫警长");
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	public void tempDir(){
		String tempDir=System.getProperty("java.io.tmpdir");
		System.out.println(tempDir);
	}
	
}
