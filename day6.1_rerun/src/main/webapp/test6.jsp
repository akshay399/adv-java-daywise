<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>in test 6</h2>
<h3>the params that test 6 gets implicitely which are same as test5 since test 6 is in same request: ${param}</h3>
<hr>
<h3>the request attribute set in test5 which is being displayed in test6 jsp: ${requestScope.product_details}
</h3>
<hr>
<h3>extra param passed in the req delogation from test5 to test 6: ${param.pId}</h3>

</body>
</html>