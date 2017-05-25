package cn.demo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo03_Statements {

	@Test
	public void testLogin() throws Exception {
		Connection con = ConnUtils.getCon();
		Scanner sc = new Scanner(System.in);
		System.err.println("plz enter your name:");
		String name = sc.nextLine();
		System.err.println("plz enter your pwd:");
		String pwd = sc.nextLine();
		//1:使用?占位
		String sql = "select * from users where name=? and pwd=?";
		//2:使用带有或是没有？号的SQL语句，生成PST对象
		PreparedStatement pst = 
				con.prepareStatement(sql);
		//3:设置参数，参数的下标从1开始
		pst.setString(1, name);
		pst.setString(2, pwd);
		System.err.println(sql);
		//4:在执行时，由于前面已经传递了SQL语句所以，不能再传递SQL语句
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			System.err.println("登录成功");
		} else {
			System.err.println("登录失败");

		}
		pst.close();
		con.close();
	}

	@Test
	public void test2() throws Exception {
		Connection con = ConnUtils.getCon();
		Statement st = con.createStatement();
		for (int i = 0; i < 10; i++) {
			// 添加批量千处理的语句
			st.addBatch("insert into stud(id,name) values (sys_guid(),'Jack')");
		}
		st.addBatch("update stud set age=100");
		int[] rows = st.executeBatch();
		System.err.println("执行了几个sql语句：" + rows.length);// 11
		System.err.println("影响的行数：" + Arrays.toString(rows));// [1,1,1,1,1,1,1,1,1,1,20]
		st.close();
		con.close();

	}

	@Test
	public void test1() throws Exception {
		Connection con = ConnUtils.getCon();
		Statement st = con.createStatement();
		String sql = "select * from stud";
		boolean boo = st.execute(sql);
		System.err.println("有返回值：" + boo);
		if (boo) {
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				String name = rs.getString("name");
				System.err.println(name);
			}
		}
		st.close();
		con.close();
	}
}
