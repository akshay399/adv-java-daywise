<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test2</title>
</head>
<%! String instanceVar = "hi i am an instance variable string."; %>
<body>
<% 
	String localVar = "hi i am a local var to _jspService written in a scriplet";
%>
<h2>hi from test2</h2>
<%@ include file="test3.jsp" %>
</body>
</html>