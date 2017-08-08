package com.oracle.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.eneity.Student;

public class StudentDao extends BaseDao {
	public List<Student> list() {
		try {
			getConnection();
			List<Student> list = new ArrayList<Student>();
			String sql = "select id,name,mobile,age,address from student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getNString(2));
				stu.setMobile(rs.getString(3));
				stu.setAge(rs.getInt(4));
				stu.setAddress(rs.getString(5));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
}
