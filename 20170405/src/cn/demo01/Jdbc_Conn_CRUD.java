package cn.demo01;
/**
 * @author xuxin
 * 在jdbc中，首先要导入不同数据库公司提供的jar包
 * 1.通过反射获取字节码
 * 2.利用connection来连接
 * 3.利用statement,preparedstatement,callablestatement来向数据库中
 * 发送sql语句
 * 4.resultset返回结果集
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import cn.utils.ConnUtils;
import cn.utils.MyConnUtils;

public class Jdbc_Conn_CRUD {
	@Test
	public void testQuery() throws Exception{
		//1.通过反射来获取字节码
		Class.forName("oracle.jdbc.OracleDriver");
		//2.声明url
		String Url = "jdbc:oracle:thin:@172.22.56.72:1521/xe";
		//3获取连接
		Connection con = DriverManager.getConnection(Url,"jack","1234");
		System.out.println("连接的是："+con);
		//4声明Statement对象
		Statement st = con.createStatement();
		//5将查询结果放入结果集中
		String sql ="select id,name,age from stud";
		ResultSet rs =st.executeQuery(sql);
		while(rs.next()){
			//6.遍历结果集，有元素就显示出来
			String id = rs.getString("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+","+name+","+age);
		}
		rs.close();
		con.close();
	}
	Scanner sc = new Scanner(System.in);
	
	@Test
	public void testInsert() throws SQLException{
		System.out.println("插入的name");
		System.out.println("插入的id");
		System.out.println("插入的age");
		String name = sc.nextLine();
		String id = sc.nextLine();
		String age = sc.nextLine();
		//直接利用工具类获取连接
		Connection con =MyConnUtils.getCon();
		//这里使用PreparedStatemnt,防止sql注入漏洞
		String sql ="insert into stud(name,id,age) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, id);
		pst.setString(3, age);
		int count = pst.executeUpdate();
		System.out.println("影响的行数为："+count);
		pst.close();
		con.close();
		
	}

	@Test
	public void testDelete() throws SQLException{
		System.out.println("请输入要删除的id");
		String id = sc.nextLine();
		Connection con =ConnUtils.getCon();
		String sql="delete from stud where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		int counts=pst.executeUpdate();
		System.out.println(counts);
		pst.close();
		con.close();
		}
	@Test
	public void testUpdate() throws SQLException{
		
		System.out.println("请输入要修改的id");
		String id = sc.nextLine();
		System.out.println("请输入修改后的name与age");
		String name = sc.nextLine();
		String age = sc.nextLine();
		Connection con =ConnUtils.getCon();
		String sql="update stud set name=?,age=? where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, age);
		pst.setString(3, id);
		int counts=pst.executeUpdate();
		System.out.println(counts);
		pst.close();
		con.close();

}
}
