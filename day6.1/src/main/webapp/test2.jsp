<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String message = "some mesg!";//instance var%>
<body>
	<%
	String anotherMesg = "some other mesg!";//local var : local to _jspService
	pageContext.setAttribute("nm1", 1234);//nm1 : page scoped attr
	%>
	<%@ include file="test3.jsp"%>
</body>
</html>