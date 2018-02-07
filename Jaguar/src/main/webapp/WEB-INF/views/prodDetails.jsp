< <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jaguar</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<div class="row">
<div class="col-sm-4 item-photo">
<img style="max-width:100%"; margin-top:30px;" 
src="${pageContext.request.contextPath }/resources/images/${prod.images5.jpg}"/>
</div>
<div class="col-sm-5" style="border:opx solid gray">
<h3>${prod.pname }</h3>
<h4>${prod.descripion }</h4>
<h4>${prod.price }</h4>
<h5>${prod.supplierName}</h5>
<div class="section" style="padding-bottom:20px;">
<form action="addToCart" meyhod="POST">
<input type="hidden" value="${prod.pid }"name="pId"/>
<input type="hidden" value="${prod.price }"name="pPrice"/>
<input type="hidden" value="${prod.pname }"name="pName"/>
<input type="hidden" value="${prod.imgName }"name="imgName"/>

<input type="number" class="form_control" name="pQTY" required/><br><br>
<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart">
<h6><span class="glyphicon-heart-empty" style="cursor:pointer:"></span> WishList</h6>

</form>

</div>

</div>

<br>
<div class="col-sm-9">
<h3>Product Details</h3>
<ul class="menu-items">
<li>All cars are subjected to both state and center GST..
<li>All reserved cars will be delivered in three months of booking..
<li>looks of cars may vary from the look given in advertisements..
<li>first three services are free.. </ul></div>
<br><br>
<h6>SAROVARA SHOWROOM IS THE ONLY AUTHORISED JAGUAR DEALER IN INDIA</h6>


</div>
 
</body>
</html>