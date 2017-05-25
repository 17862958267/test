package cn.studs.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DSUtils {
	private static DataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource();
	}
	public static DataSource dataSource(){
		return dataSource;
	}
}
