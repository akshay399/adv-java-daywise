<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--imort JSTL supplied core tag lib --%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%--WC tries to call ALL MATCHING setters --%>
<jsp:setProperty property="*" name="user" />
<body>
	<%--invoke B.L method of Java bean --%>

<c:redirect url="${sessionScope.user.addNewUser()}.jsp"/>
</body>
</html>