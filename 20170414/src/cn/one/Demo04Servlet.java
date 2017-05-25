package cn.one;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01Servlet
 */
public class Demo04Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//先从ServletContext中获取之前的访问量
		Integer count = (Integer) getServletContext().getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		//在增加完成以后，再放回到servletconteext
		getServletContext().setAttribute("count",count);
		response.getWriter().println("access count:"+count+"<hr>");
		
		
		System.err.println("request is:" + request);// 在运行时有不同一的容器实现Request对象org.apache.catalina.connector.RequestFacade@538dd7
		// 获取当前项目运行的真实的目录
		ServletContext sc = getServletContext();
		String realPath = sc.getRealPath("/imgs");
		PrintWriter out = response.getWriter();
		File file = new File(realPath);
		// 获取这个目录下的所有图片
		String[] fs = file.list();
		// 输出这些图片
		response.setContentType("text/html;charset=UTF-8");
		for (String f : fs) {
			f = URLEncoder.encode(f, "UTF-8");
			String img = "<img src='imgs/" + f + "' width='300'/>";
			out.print(img);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
