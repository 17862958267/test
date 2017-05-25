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
			response.getWriter().print("用户名或密码错误,<a href='javascript:window.history.go(-1);'>重新登录</a>");
		}else{
			String html ="登录成功了，欢迎你："+user.getName()+"<hr>"
					+ "<a href=''>学生名单</a>|<a href=''>增加学生</a>";
			response.getWriter().print(html);
		}
	}

}