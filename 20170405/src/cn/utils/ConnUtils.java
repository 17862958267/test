package cn.utils;
/**
 * @author XUXIN
 * 这是一个工具类用，用来优化数据库连接的，因为会有很多人同时连接数据库，所以直接将connection放在静态代码块中，优化性能
 *这里保证静态代码块中的连接功能只会执行一次,单例模式 
 *首先读取资源文件(里面是连接的配置),然后获取资源文件里面的配置，然后通过静态工厂方法返回对象
 *
 *
 */
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
			//自动的去加载classpath目录下的资源文件 e:/workspaces/20170504/bin/abc.properties\
			String path =  ClassLoader.getSystemResource("abc.properties").getPath();
			System.err.println("path is:"+path);
			prop.load(ClassLoader.getSystemResourceAsStream("abc.properties"));
			//获取里面的 数据
			String driver = prop.getProperty("driver");
			String url =prop.getProperty("url");
			String name = prop.getProperty("name");
			String pwd = prop.getProperty("pwd");
			
			Class.forName(driver);//获得驱动器
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
