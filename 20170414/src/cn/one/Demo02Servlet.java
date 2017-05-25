package cn.one;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo02Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("name", "Jack");
		String name =  (String) req.getAttribute("name");
		System.err.println("name is:"+name);//Jack
		
		
		resp.setContentType("text/html;charset=UTF-8");
		if (req.getHeader("referer") == null) {
			resp.getWriter().print("请先去看广播<a href='index.html'>index.html</a>");
		} else {
			resp.getWriter().print("<img src='imgs/stud.jpg' width='400' height='400'>");
		}
	}
}

