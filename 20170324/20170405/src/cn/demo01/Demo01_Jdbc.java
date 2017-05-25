package cn.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo01_Jdbc {
	@Test
	public void test1() throws Exception {
		Connection con = ConnUtils.getCon();
		// 4:获取Statement对象
		Statement st = con.createStatement();
		// 5:向数据库发送sql语句
		ResultSet rs = st.executeQuery("select * from stud");
		// 6:遍历游标
		while (rs.next()) {
			// 如果有数据，就获取里面的值
			String id = rs.getString("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.err.println(id + "," + name + "," + age);
		}
		rs.close();
		st.close();
	}

	Scanner sc = new Scanner(System.in);

	public void delete() throws Exception {
		System.err.println("请输入要被删除的id");
		String id = sc.nextLine();
		String sql = "delete from stud where id=?";
		Connection con = ConnUtils.getCon();
		// 3:获取st
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		pst.close();
	}

	public void update() throws Exception {
		System.err.println("请输入要被修改的id");
		String id = sc.nextLine();
		System.err.println("请输入修改以后的姓名和年龄：");
		String name = sc.nextLine();
		String age = sc.nextLine();
		String sql = "update stud set name=?,age=? where id=?";
		Connection con = ConnUtils.getCon();
		// 3:获取st
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setInt(2, Integer.parseInt(age));
		st.setString(3, id);
		st.executeUpdate();
		st.close();
	}

	@Test
	public void testInsert2() throws Exception {

		System.err.println("请输入学生的姓名和年龄：");
		String name = sc.nextLine();
		String age = sc.nextLine();

		Connection con = ConnUtils.getCon();
		String sql = "insert into stud(id,name,age) values(sys_guid(),?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,name);
		st.setInt(2, Integer.parseInt(age));
		System.err.println("sql is:" + sql);
		int rows = st.executeUpdate();
		System.err.println("影响几行：" + rows);
		st.close();
	}

	public static void main(String[] args) throws Exception {
		new Demo01_Jdbc();
	}

	public Demo01_Jdbc() throws Exception {
		one: while (true) {
			System.err.println("1:query,2:insert,3:delete,4:update,0:exit");
			String op = sc.nextLine();
			switch (op) {
			case "1":
				test1();
				break;
			case "2":
				testInsert2();
				break;
			case "3":
				delete();
				break;
			case "4":
				update();
				break;
			case "0":
				break one;
			default:
				break;
			}
		}
	}
}
