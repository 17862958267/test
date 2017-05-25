package cn.one;
/**注意，servlet中的init()方法默认在被访问的时候执行，所以执行的顺序为：1.这是构造方法。。。/2.这是初始化方法。。。
 * 当类被加载完成后，首先执行默认构造，但是我们可以通过配置xml文件来修改init方法被初始化的时间
 * <load-on-startup>1</load-on-startup>修改后，我们不访问时也会被初始化。
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {
	private ServletConfig config;
	//添加默认构造方法
	public FirstServlet(){
		System.out.println("1.这是构造方法。。。");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.这是初始化方法。。。");
		this.config=config;
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("2.接收用户请求，返回给用户一个对象"+this);
		//1.设置输出的数据类型
		res.setContentType("text/html;charset=UTF-8");
		//2.获取输出流
		PrintWriter out =res.getWriter();
		out.print("你好");
		//获取Servlet名称，记住首先将config声明为全局变量
		String name=config.getServletName();
		out.print("<br>Servlet的名字是"+name);
		//获取初始化方法的参数
		Enumeration<String> en =config.getInitParameterNames();
		while(en.hasMoreElements()){
			name = en.nextElement();
			String val = config.getInitParameter(name);
			out.print("<br>"+name+"="+val);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("3.Servlet生命周期结束");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
