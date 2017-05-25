package cn.demo01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo05_ResultSet {
	@Test
	public void test1() throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = ConnUtils.getCon();
		// 在创建st对象时，可以设置st对象查询以后的resultSet的结果类型
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		System.err.println("default fetch size:"+st.getFetchSize());
		st.setFetchSize(1);
		ResultSet rs = st.executeQuery("select id,name,age from stud");
		System.err.println("========================");
		while(rs.next()){
			System.err.println(rs.getString("name"));
			sc.nextLine();
		}
		con.close();
		st.close();
		rs.close();
	}
}
