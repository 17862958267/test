package cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnUtils {
	private static Connection con;
	static {
		// 只会执行一次
		try {
			//读取资源文件
			Properties prop = new Properties();
			//自动的去加载classpath目录下的资源文件 d:/workspaces/20170504/bin/abc.properties\
			String path =  ClassLoader.getSystemResource("abc.properties").getPath();
			System.err.println("path is:"+path);
			prop.load(ClassLoader.getSystemResourceAsStream("abc.properties"));
			//获取里面的 数据
			String driver = prop.getProperty("driver");
			String url =prop.getProperty("url");
			String name = prop.getProperty("name");
			String pwd = prop.getProperty("pwd");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, name, pwd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 使用静态的工厂方法
	public static Connection getCon() {
		return con;
	}
	
	public static void main(String[] args) {
		System.err.println("con is:"+con);
	}
}
