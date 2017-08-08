package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.util.DataSource;

public class BaseDao {
	protected PreparedStatement ps = null;
	protected Connection conn = null;
	protected ResultSet rs = null;

	protected Connection getConnection() {
		try {
			Class.forName(DataSource.driver);
			conn = DriverManager.getConnection(DataSource.jdbcUrl, DataSource.user, DataSource.password);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("未加载驱动！");
		} catch (SQLException e) {
			System.out.println("用户名或密码错误！");
		}
		return null;
	}
	protected void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
