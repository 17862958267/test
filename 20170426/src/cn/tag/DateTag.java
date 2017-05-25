package cn.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTag extends TagSupport {
	//当标签开始时，执行某个方法 <qlu:date> 
	@Override
	public int doStartTag() throws JspException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(new Date());
		//自定义标签的类，用于页面上，所以，只要可以获取pageContext就可以获取所有对象
		JspWriter out = pageContext.getOut();
		try {
			out.print(str);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//返回值，说明对标准的body部分忽略
		return SKIP_BODY;
	}
}
