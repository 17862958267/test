package cn.one;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//开发后台的Servlet用来接收用户提交的数据
		req.setCharacterEncoding("UTF-8");
		String name =req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//声明输出流
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out=res.getWriter();
		if(name.equals("Jack")&& pwd.equals("1234")){
			out.print("登录成功");
		}else{
			out.print("登录失败");
		}
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
