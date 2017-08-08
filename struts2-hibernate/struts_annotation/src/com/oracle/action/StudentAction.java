package com.oracle.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.dao.StudentDao;
import com.oracle.eneity.Student;

@Result(name = "listPage", location = "/WEB-INF/page/student/list.jsp")
public class StudentAction extends ActionSupport {
	private StudentDao dao = new StudentDao();
	private Student student;
	private List<Student> list;
	private Integer id;

	@Action(value = "list")
	public String list() {
		list = dao.list();
		return "listPage";
	}

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
