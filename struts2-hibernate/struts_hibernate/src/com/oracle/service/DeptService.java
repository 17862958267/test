package com.oracle.service;

import com.oracle.dao.DeptDao;
import com.oracle.entity.Dept;
import com.oracle.model.PageBean;

public class DeptService extends BaseService<Dept>{

	//创建DeptService时候,自动为其父类中的dao属性赋值
	public DeptService(){
		dao=new DeptDao();
	}
	
	
	
}
