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
		
		Province province1=new Province("a1", "cd1");
		Province province2=new Province("a2", "cd2");
		Province province3=new Province("a3", "cd3");
		Set<Province> set=new HashSet<Province>();
		set.add(province1);
		set.add(province2);
		set.add(province3);
		
		Country country=new Country("abcd");
		
		country.setProvinceSet(set);
		
		session.save(country);
		
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	
}
