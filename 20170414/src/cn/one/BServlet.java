package cn.one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getAttribute("name");
		System.err.println("2:name is:" + name);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<br>BB<br>");
		
	String nm = (String) getServletContext().getAttribute("name");
	response.getWriter().print("<br>在servletContext中的值是:"+nm);
	
	String nnn = (String)request.getAttribute("addr");
	response.getWriter().print("<br>在req中的值是:"+nnn);
	}

}

