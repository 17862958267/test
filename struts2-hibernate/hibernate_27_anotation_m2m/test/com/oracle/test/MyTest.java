package com.oracle.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Role;
import com.oracle.entity.User;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		
		Role role1=new Role("角色1", "c1");
		Role role2=new Role("角色2", "c2");
		Set<Role> set=new HashSet<Role>();
		set.add(role1);
		set.add(role2);
		
		
		User user=new User("张三", "zhangsan");
		user.setRoleSet(set);
		
		
		session.save(user);
		
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	
}
