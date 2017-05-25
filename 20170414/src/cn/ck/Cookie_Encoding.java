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
		//1.声明要保存的中文
		String name ="张三";
		//2.对中文进行编码,并输出
		name = URLEncoder.encode(name,"UTF-8");
		System.out.println("name is:"+name);
		Cookie c = new Cookie("name",name);
		response.addCookie(c);
		//3.获取Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String key =cookie.getName();
				String val =cookie.getValue();
				if(key.equals("name")){
					System.out.println("value is"+val);
					//上面显示出来的是乱码，我们可以解码得到原来的值
					val =URLDecoder.decode(val,"UTF-8");
					System.out.println("解码后的值是"+val);
				}
				
			}
		}
    }

	

}
