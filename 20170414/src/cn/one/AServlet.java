package cn.one;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AServlet
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("1");
		request.setAttribute("name", "Jerry");
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<br>AA<br>");
		//×ª·¢
		RequestDispatcher rd = request.getRequestDispatcher("/b");
		rd.include(request, response);
		System.err.println("3");
		response.getWriter().print("<br>Over<br>");
	}
}
