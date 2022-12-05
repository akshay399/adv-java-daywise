<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.txtArea{
	
        position: absolute;
        top: 70%;
        left: 60%;
        transform: translate(-50%, -50%);
}
.center {

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
	  <a href="#" class="w3-bar-item w3-button">SignOut</a>
	</div>

	<!-- Page Content -->
	<div style="margin-left:25%">
		
		<div class="w3-container w3-teal">
		  <h1>new Blogs</h1>
		</div>
		<hr/>
			<form method = "post">
			Title: <input name="title" type="text"/>
			Category: <input name="category" type="text"/>
			<input type="submit" value="Add Category" />
		
			<hr />
			<textarea name="textarea" rows="9" cols="40">
			</textarea>
			<hr />
			<input type="submit" value="Add blog" />
			</form>
	
	</div>
</div>


</body>
</html>


