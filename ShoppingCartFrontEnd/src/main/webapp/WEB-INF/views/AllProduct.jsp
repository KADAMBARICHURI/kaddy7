<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllProduct</title>
</head>
<body>

<c:set var="image" value="resources/image/" />

<c:if test="${!empty productList}">
		<table class="tg">
			
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td> 
					<td>
					<img alt="${product.name}"
				src="${image}${product.id}.jpg"></td>
				<td><c:if test="${isUserLoggedIn=='true'}">
				<a href="myCart_add/${product.id}" class="btn btn-success">
									Add to cart <i class="fa fa-cart-plus" aria-hidden="true"></i></a>
									</td>
</c:if>							
				</tr> <br>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>