<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>

<h3>hi</h3>
<h5>
<a href="test1.jsp">Test Error Handling in JSP</a>
	</h5>
	<h5>
		<a href="test2.jsp">Test include directive</a>
	</h5>
	<h5>
	<%
	String encUrl = response.encodeURL("trial.jsp");
	%>
	<%session.setAttribute("key", "this is the trail"); %>
	<a href="<%=encUrl%>">Trial encodeURL</a>
		
	</h5>
	<h5><a href="test4.jsp">Test forward or include action</a></h5>
	<h5><a href="login.jsp">Login</a></h5>
</body>
</html>