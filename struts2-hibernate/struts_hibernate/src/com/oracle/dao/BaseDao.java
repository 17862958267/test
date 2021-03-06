package com.oracle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.oracle.util.HibernateUtil;


/*
 * 将当前类定义为抽象类,主要是为了强迫子类重写countAll()和findAll()方法
 * 如果这两个方法不是抽象方法,那么子类可以不重写,但是会产生问题
 * 
 * */
public abstract class BaseDao<T> {

	
	public int save(T obj){
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int id = (int) session.save(obj);
		session.getTransaction().commit();
		HibernateUtil.closeSession();
		
		return id;
	}
	
	public void update(T obj){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
	public void delete(T obj){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
	public T find(Class clazz,int id){
		Session session = HibernateUtil.getSession();
		
		T obj=(T)session.get(clazz, id);
		
		HibernateUtil.closeSession();
		return obj;
	}
	
	
	
	public List<T> findAll(String hql){
		Session session=HibernateUtil.getSession();
		
		Query query=session.createQuery(hql);
		
		List<T> list=query.list();
		
		HibernateUtil.closeSession();
		
		return list;
	}
	
	/*
	 * 如果该分页方法需要每一个子类去重写实现,可以将其定义为抽象方法
	 * 如果不需要子类必须实现,可以定义为普通方法,其核心业务逻辑为空即可
	 * */
	public List<T> findAll(int currentPage,int pageSize,T obj){
		return null;
	}
	
	
	public int countAll(String hql){
		Session session=HibernateUtil.getSession();
		
		Query query=session.createQuery(hql);
		
		Long count =  (Long) query.uniqueResult();
		
		HibernateUtil.closeSession();
		
		return Integer.parseInt(count.toString());
	}
	
	public int countAll(T obj){
		return 0;
	}
}
