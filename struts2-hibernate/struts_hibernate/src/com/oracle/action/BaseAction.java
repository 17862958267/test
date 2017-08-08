package com.oracle.action;

import org.apache.struts2.ServletActionContext;

import com.oracle.service.DeptService;
import com.oracle.service.RoomService;
import com.oracle.service.StudentService;
import com.oracle.service.UserService;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class BaseAction {

	
	protected HttpServletRequest request=ServletActionContext.getRequest();
	protected HttpServletResponse response=ServletActionContext.getResponse();
	protected HttpSession session=request.getSession();
	
	
	
	protected DeptService deptService=new DeptService();
	protected RoomService roomService=new RoomService();
	protected StudentService studentService=new StudentService();
	protected UserService userService=new UserService();
	
}
