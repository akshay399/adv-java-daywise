<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
in test 5: ${param} 	
<% request.setAttribute("product_details", request.getParameter("product_name") + "@" + request.getParameter("price"));%>
hi <h1>${sessionScope.trial}</h1>

<jsp:include page="test6.jsp">
<jsp:param value="100" name="pId" />
</jsp:include>
</body>
</html>