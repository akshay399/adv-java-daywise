<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
</head>
<body>
<!-- ${sessionScope.product.fetchProducts()} -->
<c:forEach var="prod" items="${sessionScope.product.fetchProducts()}">
	${prod.id} ${prod.productName} ${prod.price} belongs to Category <h5>${prod.productCategory.categoryName}</h5>
</c:forEach>
</body>
</html>
