package cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyConnUtils {
	
	private static Connection con;//声明私有静态变量
     static{//保证只会执行一次
    	 try{
    		 Properties prop = new Properties();
    		 prop.load(ClassLoader.getSystemResourceAsStream("abc.properties"));
    		 String driver = prop.getProperty("driver");
    		 String url = prop.getProperty("url");
    		 String name = prop.getProperty("name");
    		 String pwd = prop.getProperty("pwd");
    		 //获取驱动器
    		 Class.forName(driver);
    		 //获取连接
    		 con= DriverManager.getConnection(url,name,pwd);
    		 
    	}catch(Exception e){
    		throw  new RuntimeException (e);
    		
    	}
    	 
     }
     public static Connection getCon(){//静态工厂方法返回con;
    	 return con;
     }
     
     
     
}
