package com.oracle.action;

import java.util.List;

import com.oracle.entity.Student;
import com.oracle.model.PageBean;

public class StudentAction extends BaseAction {

	
	private PageBean pb;
	private int currentPage;
	private List<Student> list;
	private Student student;
	private Integer id;
	
	public String list(){
		PageBean pb=studentService.findPageBean(currentPage, 10, student);
		return "listPage";
	}
}
