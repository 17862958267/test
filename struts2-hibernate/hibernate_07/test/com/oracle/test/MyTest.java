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
		
		Country country=new Country("中国");
		
		Province province1=new Province("河北");
		Province province2=new Province("河南");
		Province province3=new Province("山东");
		Province province4=new Province("山西");
		Set<Province> set=new HashSet<Province>();
		set.add(province1);
		set.add(province2);
		set.add(province3);
		set.add(province4);
		
		//object references an unsaved transient instance - save the transient instance before flushing: com.oracle.entity.Province
		//country引用了瞬时态(临态)的province的数据,在保存country信息之前,应该先把这些瞬时态(临态)的数据保存下来
//		session.save(province1);
//		session.save(province2);
//		session.save(province3);
//		session.save(province4);
		
		country.setProvinceSet(set);
		
		
		session.save(country);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	
}
