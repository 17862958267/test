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
		//������̨��Servlet���������û��ύ������
		req.setCharacterEncoding("UTF-8");
		String name =req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//���������
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out=res.getWriter();
		if(name.equals("Jack")&& pwd.equals("1234")){
			out.print("��¼�ɹ�");
		}else{
			out.print("��¼ʧ��");
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
