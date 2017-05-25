<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 out.println(request.getHeader("user-agent"));
 %>
 <br>
 <%=request.getHeader("user-agent")%>
 <br>
 ${header['user-agent']}
 <hr>
 ${header}
 <hr>
 ${header.accept}
 <hr>
 ${headerValues}
 ${headerValues.accept[0]}
 
 
 
</body>
</html>