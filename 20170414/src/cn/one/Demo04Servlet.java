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

		//�ȴ�ServletContext�л�ȡ֮ǰ�ķ�����
		Integer count = (Integer) getServletContext().getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		//����������Ժ��ٷŻص�servletconteext
		getServletContext().setAttribute("count",count);
		response.getWriter().println("access count:"+count+"<hr>");
		
		
		System.err.println("request is:" + request);// ������ʱ�в�ͬһ������ʵ��Request����org.apache.catalina.connector.RequestFacade@538dd7
		// ��ȡ��ǰ��Ŀ���е���ʵ��Ŀ¼
		ServletContext sc = getServletContext();
		String realPath = sc.getRealPath("/imgs");
		PrintWriter out = response.getWriter();
		File file = new File(realPath);
		// ��ȡ���Ŀ¼�µ�����ͼƬ
		String[] fs = file.list();
		// �����ЩͼƬ
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
