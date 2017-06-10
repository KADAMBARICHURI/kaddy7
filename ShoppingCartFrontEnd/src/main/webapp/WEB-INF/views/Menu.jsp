<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  --> 
  
  
   <link rel="stylesheet" href="resources/css/bootstrap.css">  
  <link rel="stylesheet" href="resources/js/bootstrap.js">
  
  <!-- <script src="resources/js/bootstrap.js" ></script> -->
  
 <!--   <script src="src/main/webapp/WEB-INF/resources/js/bootstrap.js" ></script>
  
  --> 
   
</head>
<body>




<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <ul class="nav navbar-nav">
    
    <c:forEach var="category" items="${categoryList}">
    
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">clothes</a></li>
          <li><a href="#">jewellery</a></li>
          <li><a href="#">sandals</a></li>
        </ul>
      </li>
      
    </c:forEach>
     </ul>
     
     
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
    <c:when  test="${isUserLoggedIn=='true'}">
	<li><a href="myCart"><span class="glyphicon glyphicons-"></span> Cart</a></li>	
	<li><a href="SignOut"><span class="fa fa-sign-out" aria-hidden="true"></span> SignOut</a></li>
	</c:when>
    <c:when test="${isAdmin=='true'}">	
	<li><a href="SignOut"><span class="fa fa-sign-out" aria-hidden="true"></span> SignOut</a></li>
	</c:when>
	<c:otherwise>
    
      <li><a href="RegistrationPage"><span class="glyphicon glyphicons-user"></span> Sign Up</a></li>
      <li><a href="LoginPage"><span class="glyphicon glyphicons-log-in"></span> Login</a></li>
      </c:otherwise>
      </c:choose>
    </ul>  
    
   
  </div>
</nav>
  


</body>
</html>
