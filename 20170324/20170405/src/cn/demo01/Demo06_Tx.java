package cn.demo01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo06_Tx {
	@Test
	public void testQuery() throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = ConnUtils.getCon();
		Statement st = con.createStatement();

		System.err.println("plz enter name:");
		String name = sc.nextLine();
		System.err.println("plz enter age:");
		String age = sc.nextLine();
		System.err.println("plz enter sex:");
		String sex = sc.nextLine();
		System.err.println("plz enter addr:");
		String addr = sc.nextLine();

		String sql = "select * from tacher where 1=1";
		if (name != null && !name.trim().equals("")) {
			sql += " and name like '%" + name + "%'";
		}
		if (age != null && !age.trim().equals("")) {
			sql += " and age=" + age;
		}
		if (sex != null && !sex.trim().equals("")) {
			sql += " and sex='" + sex + "'";
		}
		if (addr != null && !addr.trim().equals("")) {
			sql += " and addr like '%" + addr.trim() + "%'";
		}

		System.err.println("sql is:" + sql);

		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			name = rs.getString("name");
			age = rs.getString("age");
			addr = rs.getString("addr");
			System.err.println(name + "," + age + "," + addr);
		}
		rs.close();
		st.close();
		con.close();

	}

	@Test
	public void test1() throws Exception {
		Connection con = ConnUtils.getCon();
		Statement st = con.createStatement();
		try {
			// 1:开始事务
			con.setAutoCommit(false);
			st.execute("insert into stud values(sys_guid(),'Jerry',33)");
			st.execute("insert into stud values(sys_guid(),'Mike',44')");
			// 如果成功，就提交
			con.commit();
		} catch (Exception e) {
			// 如果出错，就回滚
			con.rollback();
			throw e;
		} finally {
			con.setAutoCommit(true);
			st.close();
			con.close();
		}
	}
}
