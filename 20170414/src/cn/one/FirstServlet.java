package cn.one;
/**ע�⣬servlet�е�init()����Ĭ���ڱ����ʵ�ʱ��ִ�У�����ִ�е�˳��Ϊ��1.���ǹ��췽��������/2.���ǳ�ʼ������������
 * ���౻������ɺ�����ִ��Ĭ�Ϲ��죬�������ǿ���ͨ������xml�ļ����޸�init��������ʼ����ʱ��
 * <load-on-startup>1</load-on-startup>�޸ĺ����ǲ�����ʱҲ�ᱻ��ʼ����
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
	//���Ĭ�Ϲ��췽��
	public FirstServlet(){
		System.out.println("1.���ǹ��췽��������");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.���ǳ�ʼ������������");
		this.config=config;
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("2.�����û����󣬷��ظ��û�һ������"+this);
		//1.�����������������
		res.setContentType("text/html;charset=UTF-8");
		//2.��ȡ�����
		PrintWriter out =res.getWriter();
		out.print("���");
		//��ȡServlet���ƣ���ס���Ƚ�config����Ϊȫ�ֱ���
		String name=config.getServletName();
		out.print("<br>Servlet��������"+name);
		//��ȡ��ʼ�������Ĳ���
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
		System.out.println("3.Servlet�������ڽ���");
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
