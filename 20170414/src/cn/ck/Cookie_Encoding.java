package cn.ck;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie_Encoding
 */
public class Cookie_Encoding extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����Ҫ���������
		String name ="����";
		//2.�����Ľ��б���,�����
		name = URLEncoder.encode(name,"UTF-8");
		System.out.println("name is:"+name);
		Cookie c = new Cookie("name",name);
		response.addCookie(c);
		//3.��ȡCookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String key =cookie.getName();
				String val =cookie.getValue();
				if(key.equals("name")){
					System.out.println("value is"+val);
					//������ʾ�����������룬���ǿ��Խ���õ�ԭ����ֵ
					val =URLDecoder.decode(val,"UTF-8");
					System.out.println("������ֵ��"+val);
				}
				
			}
		}
    }

	

}
