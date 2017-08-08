package com.oracle.service;

import com.oracle.dao.BaseDao;
import com.oracle.model.PageBean;

public class BaseService_bak<T extends BaseDao<E>,E> {

	public PageBean findPageBean(T dao,int currentPage){
		PageBean pb=new PageBean(currentPage);

		/*
		 * 当前的dao是面向baseDao编程的
		 * 所以这里只能调用baseDao中定义的方法
		 * 如果baseDao中没有定义无参数的countAll和findAll,那么这样的架构模式无法实现
		 * 
		 * */
		//pb.setMaxSize(dao.countAll());
		//pb.setList(dao.findAll());
		
		
		return pb;
	}
}
