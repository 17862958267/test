package cn.one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01Servlet
 */
public class Demo01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1:获取参数
		String name = request.getParameter("name");
		
		String addr = request.getParameter("addr");
		
		System.err.println(name+","+addr);
		
		//获取用户有可能选择的所有的值
		String[] hs = request.getParameterValues("hobby");
		if(hs!=null){
			for(String h:hs){
				System.err.println(h);
			}
		}
		
		String clientIp = request.getRemoteAddr();
		System.err.println(clientIp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}