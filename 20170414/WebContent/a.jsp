<%@page import="java.rmi.Remote"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <p>这是第一个jsp页面</p>
   <%
    pageContext.setAttribute("name", "Jack");
   %>
   <br>
   <%
    String name = (String)pageContext.getAttribute("name");
    out.print("name is:"+name);
   %>
   <%
   pageContext.setAttribute("addr", "YZ",pageContext.REQUEST_SCOPE);//指定对象目标，只能友request对象获取
   %>
   <%
   out.print("<br>"+request.getAttribute("addr"));//可以访问域对象中的其他数据
   %>
   <%//查找值
       pageContext.setAttribute("addr", "SDJN");
		request.setAttribute("addr", "BJ");
		session.setAttribute("addr","SH");
		application.setAttribute("addr", "YZ");
	
  %>
  <hr>
  <%
       out.print(pageContext.findAttribute("addr"));  
  %>

</body>
</html>