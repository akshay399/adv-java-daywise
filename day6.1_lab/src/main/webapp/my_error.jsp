<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
<h2>ERROR PAGE
</h2>
<h4>
	<%=exception %>
	<br>
	Error Details<%=exception.getMessage()%>
	<br>
	${pageContext.exception}
</h4>
	Status code: ${pageContext.errorData.statusCode}

</body>
</html>