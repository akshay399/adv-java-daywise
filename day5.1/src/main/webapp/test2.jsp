<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page ....</h5>
	<%
	//out.flush();
	//JSP Scriptlet
	//how to add attrs under 4 different scopes ?
	pageContext.setAttribute("nm1", 1234);//int --> Integer --> Object
	request.setAttribute("nm2", 1235);
	session.setAttribute("nm3", 1236);
	application.setAttribute("nm4", 1237);
	//server pull : forward
	//RequestDispatcher rd = request.getRequestDispatcher("test3.jsp");
	//rd.include(request, response);
	//clnt pull 
	response.sendRedirect("test3.jsp");
	%>
</body>
</html>