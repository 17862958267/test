package cn.studs.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studs.domain.User;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		new RegService().reg(user);
		//ֻҪע��ɹ�
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("ע��ɹ��ˣ�����ȥ<a href='"+request.getContextPath()+"/index.html'>��¼</a>");
		
	}
}
