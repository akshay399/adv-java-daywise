<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 1st page</h4>
	<h4>Param : ${param}</h4>
	<%
	out.flush();
	pageContext.setAttribute("name", "akshay");
	request.setAttribute("product_dtls", request.getParameter("prod_name") + "@" + request.getParameter("price"));
	%>
	<jsp:include page="test5.jsp">
		<jsp:param value="100" name="product_id" />
	</jsp:include>
</body>
</html>