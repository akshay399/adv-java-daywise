<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test 2</title>
</head>
<%! String message =  "hello from instance of test1" ;%>
<body>
<h2>Hello from test2</h2>
<%
String localVar = "this is declared inside a scriplet hence local var for _jspService from test1";
pageContext.setAttribute("name", "akshay");
%>
<%@ include file="test3.jsp" %>
<h3>Hello at the end of test2</h3>
<hr>
<h2>will this work? <%=test3IVar %></h2>
</body>
</html>