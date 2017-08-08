package com.oracle.test;

import java.sql.Connection;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.util.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MyTest {
	
	@Test
	public void none() throws InterruptedException{
		Session session=HibernateUtil.getSession();
		session.beginTransaction();

		
		Country country=(Country) session.get(Country.class, 5);
		
		
		country.setCname("王五1");
		
		
		//Thread.sleep(10000);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
