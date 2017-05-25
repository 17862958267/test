package cn.filter;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class OneFilter implements Filter{

	private HttpServletResponse response;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化方法"+this);
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//利用过滤器来设置图片缓存时间
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 8);
		HttpServletResponse res = (HttpServletResponse) response;
		res.addDateHeader("expires", c.getTimeInMillis());
		chain.doFilter(request, response);// 放行
		
	}

	@Override
	public void destroy() {
		
		
	}

}
