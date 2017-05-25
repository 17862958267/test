package cn.demo02.stud;

import java.util.List;

import org.junit.Test;

import cn.demo02.stud.service.StudService;
import cn.domain.Stud;

public class StudAction {
	private StudService studService = new StudService();
	@Test
	public void testQuery(){
		List<Stud> list = studService.query();
		//显示
		for(Stud s:list){
			System.err.println(s.getId()+","+s.getName()+","+s.getAge());
	
		}
	}
}
