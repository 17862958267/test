package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		
		Country country=new Country("abcd");
		//country.setCid(1);
		session.save(country);
		
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		
		Province province=new Province("aaaname", "aacode");
		
		
		session.save(province);
		
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	
}
