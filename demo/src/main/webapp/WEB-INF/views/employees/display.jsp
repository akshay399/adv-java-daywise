<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border:1px solid black;
  background-color: lightgrey;
}
</style>
</head>
<body>
<h2>Employees: </h2>
<center>
<table>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Location</th>
    <th>salary</th>
    <th>join date</th>
  </tr>
<c:forEach var="employee" items="${requestScope.employees}">
 <tr>
    <td>${employee.firstName}</td>
    <td>${employee.lastName}</td>
    <td>${employee.location}</td>
    <td>${employee.location}</td>
    <td>${employee.location}</td>
  </tr>
</c:forEach>
</table>
</center>
</body>
</html>