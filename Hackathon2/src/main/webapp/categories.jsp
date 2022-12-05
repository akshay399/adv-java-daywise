<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%--session.getAttribute("user") -- null -- session.setAttribute("user",new UserBean()); --%>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
	<h4 align="center">
		Session ID :
		<%=session.getId()%></h4>
	<h5 style="color: red;">${sessionScope.user.message}</h5>
	
	<div class="main_container">
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
  <h3 class="w3-bar-item">Hello $//{name here}</h3>
  <a href="#" class="w3-bar-item w3-button">New Block</a>
  <a href="#" class="w3-bar-item w3-button">My Blogs</a>
  <a href="#" class="w3-bar-item w3-button">Find Blogs</a>
  <a href="categories.jsp" class="w3-bar-item w3-button">Categories</a>
</div>

<!-- Page Content -->
<div style="margin-left:25%">

<div class="w3-container w3-teal">
  <h1>Sunbeam Blogs</h1>
</div>

<div>
<hr />
<form method = "post">
Category: <input name="category" type="text"/>
<input type="submit" value="Add Category" />
</form>
</div>
<hr />
<div class="w3-container">
<table class="center">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Age</th>
  </tr>
  <tr>
    <td>Jill</td>
    <td>Smith</td>
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td>
    <td>94</td>
  </tr>
  <tr>
    <td>John</td>
    <td>Doe</td>
    <td>80</td>
  </tr>
</table>
</div>

</div>
	</div>

	
</body>
</html>