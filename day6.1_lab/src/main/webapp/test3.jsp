<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test3</title>
</head>
<%! String test3IVar = "hello test3 instance variable."; %>
<body>
<h2>Hello from test3</h2>
<h2>instance var from test1: <%= message %></h2>
<h2>Name from test2 as pageContext attribute: <%= pageContext.getAttribute("name") %></h2>
<h2>instance var from test1: <%= localVar %></h2>
</body>
</html>