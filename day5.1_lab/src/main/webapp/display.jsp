<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	out.write("<h2 style='align:center'>Implicit jsession id: "+ session.getId() +"</h2>");
String name = request.getParameter("name");
	out.write(name);
	String driver=config.getInitParameter("dname");  
	out.print("driaaver name is="+driver);  
%>
</body>
</html>