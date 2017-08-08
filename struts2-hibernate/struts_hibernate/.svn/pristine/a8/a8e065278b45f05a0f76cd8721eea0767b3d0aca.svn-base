package com.oracle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.oracle.entity.Dept;
import com.oracle.util.HibernateUtil;

public class DeptDao extends BaseDao<Dept>{

	public List<Dept> findAll(int currentPage,int pageSize,Dept dept){
		String hql="from Dept d where d.name like concat('%',?,'%')";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setString(0,dept.getName());
		query.setFirstResult((currentPage-1)*pageSize );
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public int countAll(Dept dept){
		String hql="select count(d.id) from Dept d where d.name like concat('%',?,'%')";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setString(0,dept.getName());
		Long count =  (Long) query.uniqueResult();
		HibernateUtil.closeSession();
		return Integer.parseInt(count.toString());
	}
	
	
	public List<Dept> findAll(){
		String hql="from Dept ";
		return super.findAll(hql);
	}
	
	public int countAll(){
		String hql="select count(id) from Dept";
		return super.countAll(hql);
	}
	
}
