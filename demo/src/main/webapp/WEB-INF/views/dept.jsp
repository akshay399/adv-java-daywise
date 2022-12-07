<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h2>Welcome</h2></center>
	<h2>Choose dept </h2>
	<%-- <a href="employees/display">to list</a> --%>
<spring:url var="url" value="/employees/display" />
<form action=${url} method="get">
	<select  name="deptId">
	<c:forEach var="dept" items="${requestScope.dept_list}">
	<option  value="${dept.id}">${dept.deptName}</option>
	</c:forEach>
	</select>
	<hr />
	<br/>
	<input type="submit" value="choose dept" />
</form>
</body>
</html>