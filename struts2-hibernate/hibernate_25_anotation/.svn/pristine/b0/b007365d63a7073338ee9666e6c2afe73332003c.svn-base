package com.oracle.test;

import java.util.HashSet;
import java.util.Set;

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
		
		Province province=new Province("a1", "cd1");
		
		Country country=new Country("abcd");
		
		province.setCountry(country);
		
		session.save(province);
		
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	
}
