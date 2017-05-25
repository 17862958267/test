package cn.studs.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studs.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user = new LoginService().login(user);
		response.setContentType("text/html;charset=UTF-8");
		if(user==null){
			response.getWriter().print("�û������������,<a href='javascript:window.history.go(-1);'>���µ�¼</a>");
		}else{
			String html ="��¼�ɹ��ˣ���ӭ�㣺"+user.getName()+"<hr>"
					+ "<a href=''>ѧ������</a>|<a href=''>����ѧ��</a>";
			response.getWriter().print(html);
		}
	}

}