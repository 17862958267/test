package cn.demo02.stud.service;

import java.util.List;

import cn.demo02.stud.dao.StudDaoJdbc;
import cn.domain.Stud;

public class StudService {
	private StudDaoJdbc studDao = new StudDaoJdbc();
	public List<Stud> query(){
		return studDao.query();
	}
}
