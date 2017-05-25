package cn.demo02.stud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.domain.Stud;
import cn.utils.ConnUtils;

public class StudDaoJdbc {
	public List<Stud> query() {
		List<Stud> list = new ArrayList<>();// 声明一个集合类，用于保存所有查询出来的学生
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnUtils.getCon();
			st = con.createStatement();
			String sql = "select id,name,age from stud";
			rs = st.executeQuery(sql);
			while (rs.next()) {// 开始进行数据的封装
				Stud stud = new Stud();// 一行数据，就是一个学生的对象
				stud.setId(rs.getString("id"));
				stud.setName(rs.getString("name"));
				stud.setAge(rs.getInt("age"));
				list.add(stud);// 添加到集合中去
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return list;
	}
}
