<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- since we want jsp in further steps too we will make jsp here on welcome page -->
<jsp:useBean id="product" class="beans.ProductBean" scope="session" />
<body>
<h3> Welcome 2 Web App with Hibernate @ <%= new Date() %></h3>
<h5>a<a href="display.jsp">Display all products</a></h5>
</body>
</html>