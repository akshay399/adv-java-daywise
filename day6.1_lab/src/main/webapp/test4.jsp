<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test5</title>
</head>
<body>
<h3>
Param: ${param}
</h3>

<%
	request.setAttribute("prod_details", 
			request.getParameter("prod_name") + "@" + request.getParameter("price"));
%>
<jsp:include page="test5.jsp">
		<jsp:param value="100" name="product_id" />
	</jsp:include>

</body>
</html>