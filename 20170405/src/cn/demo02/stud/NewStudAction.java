package cn.demo02.stud;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.domain.Stud;
import cn.utils.ConnUtils;

public class NewStudAction {
	@Test
	public void test() throws Exception{
	QueryRunner run = new QueryRunner();
	Connection con = ConnUtils.getCon();
    List<Stud> list = run.query(con,"select id,name,age from stud",new BeanListHandler<Stud>(Stud.class));
    System.out.println(list);
	
	}
}
