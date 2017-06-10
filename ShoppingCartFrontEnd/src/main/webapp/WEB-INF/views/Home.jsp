<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Shopping Cart Web Application</title>

<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/cloud-zoom.css" />" rel="stylesheet">


<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>

</head>
<body>


  <center>
  
      <h2>Welcome To Shopper's Land</h2>
      
      
   </center>
   
   
	<!-- Display Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	
	<!-- Display messages -->
	<div class="container-fluid">
		<marquee>
			
			<strong class="text-danger">${message} </strong>
			
		</marquee>
	</div>

	

	<!-- Display Admin Control Panel -->
	<c:if test="${isAdmin=='true'}">
		<jsp:include page="Admin/AdminHome.jsp"></jsp:include>
	</c:if>
	
	<!-- Display Admin Control Panel -->
	<c:if test="${isAdminClickedCategories=='true'}">
		<jsp:include page="Admin/Category.jsp"></jsp:include>
	</c:if>
	
	<!-- Display Checkout Message -->
	<c:if test="${isUserCheckedOut=='true'}"> 
		<jsp:include page="User/checkOut.jsp"></jsp:include>
	</c:if>
	
	<!-- Display cart content -->
	<c:if test="${isUserClickedCart=='true'}">
		<jsp:include page="User/Cart.jsp"></jsp:include>
	</c:if>

	
	
	
	<!-- Display admin  Supplier -->
	<c:if test="${isAdminClickedSuppliers=='true' }">
		<jsp:include page="Admin/Supplier.jsp"></jsp:include>
	</c:if>

	<!-- Display admin Products -->
	<c:if test="${isAdminClickedProducts=='true' }">
		<jsp:include page="Admin/Product.jsp"></jsp:include>
		<div class="container col-sm-offset-3 col-sm-9" style="color: green">${pMessage}</div>
	</c:if>
	
	<!-- Display admin Contact Us -->
	<c:if test="${isAdminClickedContactUs=='true' }">
		<jsp:include page="Admin/AdminContactUs.jsp"></jsp:include>
		<div class="container col-sm-offset-3 col-sm-9" style="color: green">${contactUsMessage}</div>
	</c:if>
	
	
	<!-- Display user Contact us -->
	<c:if test="${isUserClickedContactUs=='true' }">
		<jsp:include page="ContactUs.jsp"></jsp:include>
	</c:if>

	<!-- Display LoginPage -->
	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

	<!-- Display Registration Page -->
	<c:if test="${isUserClickedRegistration=='true'}">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>
	
	<!-- Display Carousel and Products -->
	<c:if test="${isUserAtHomePage=='true'}">
	
		<jsp:include page="AllProduct.jsp"></jsp:include>
	</c:if>

	
	
	<!-- Display Footer -->
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>