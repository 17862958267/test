package cn.ck;
/**1.��ȡ��ǰʱ����ʾ���������
 * 2.����Cookie�������һ�η���ʱ��ʱ��
 * ��ΪlastTime
 * 3.��Cookie�б�������ݷ��͵�����������棬��Ϊcookie�б�������ݲ��ܱ����������棬��session���Ա�����������
 *Ĭ��ʱ��Ϊ30���� 
 * @author Administrator
 * 4.�Ժ��ٷ���ʱ����ȡcookie�����ݣ���ʾʱ�䵽������С�
 * ��������ΪLastTime��cookie,����ֵΪ��ǰʱ�䣬��֤�������ķ����õ�����ǰһ�εķ��ʵ�ʱ��
 * 5.�ɸ��º��cookie ���͸����������
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
		
		//��ȡ��ǰʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime = format.format(new Date());
		
		
		//ȡ��cookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")){
					//��lastTime��cookie���Ѿ��ǵ�n�η���
					lastTime = cookie.getValue();//�ϴη��ʵ�ʱ��
					//��n�η���
					//1.���ϴ���ʾʱ����ʾ�������
					response.getWriter().write("��ӭ���������ϴη��ʵ�ʱ��Ϊ��"+lastTime+",��ǰʱ��Ϊ��"+curTime);
					//2.����cookie
					cookie.setValue(curTime);
					cookie.setMaxAge(1*30*24*60*60);
					//3.�Ѹ��º��cookie���͵������
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		/**
		 * ��һ�η��ʣ�û��cookie �� ��cookie����û����ΪlastTime��cookie��
		 */
		if(cookies==null || lastTime==null){
			//1.��ʾ��ǰʱ�䵽�����
			response.getWriter().write("�����״η��ʱ���վ����ǰʱ��Ϊ��"+curTime);
			//2.����Cookie����
			Cookie cookie = new Cookie("lastTime",curTime);
			cookie.setMaxAge(1*30*24*60*60);//����һ����
			//3.��cookie���͵����������
			response.addCookie(cookie);
		}
	}

}
