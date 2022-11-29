<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- message --%>
	<%-- session.getAttribute("user").getMessage()--sent to clnt --%>
	<h4>${sessionScope.user.message}</h4>
	<%-- user's greet with name --%>
	<h5>Hello , ${sessionScope.user.validatedUserDetails.firstName}</h5>
	<%--discard http session --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out</h5>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>

</body>
</html>