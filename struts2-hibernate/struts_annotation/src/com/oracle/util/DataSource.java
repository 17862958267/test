package com.oracle.util;

import java.util.Properties;

public class DataSource {
	public static String driver;
	public static String jdbcUrl;
	public static String user;
	public static String password;

	static {
		try {
			Properties p = new Properties();
			p.load(DataSource.class.getResourceAsStream("/jdbc.properties"));
			driver = p.getProperty("driver");
			jdbcUrl = p.getProperty("jdbcUrl");
			user = p.getProperty("user");
			password = p.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
