package cn.demo01;
/**
 * 在java中执行sql语句后，数据库会返回结果集，我门可以对结果集的类型进行设置
 * 比如设置游标每次读取的最大行数（默认读取的行数为10），以及从头到尾遍历还是从结尾到开头遍历。
 */
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
		//st.setFetchSize(1);
		ResultSet rs = st.executeQuery("select name,id,age from stud");
		rs.afterLast();
	    while(rs.previous()){
		String name =rs.getString("name");
		String id =rs.getString("id");
		String age =rs.getString("age");
		System.out.println(name+","+id+","+age);
		}
		
		con.close();
		st.close();
		rs.close();
	}
}
