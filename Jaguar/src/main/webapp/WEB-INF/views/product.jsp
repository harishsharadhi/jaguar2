<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jquery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/3.3.7/css/font-awesome.min.css" rel="stylesheet">  
<title>SAROVARA MODEL</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>Insert title here</title>
<style>table, th, td {
    border: 1px solid black;
    }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
	<div class="navbar-header">
	<a class="navbar-brand" href="#">JAGUAR ONLINE BUSSINESS</a>
</div>
<ul class="nav navbar-nav">
<li class="active"><a href="index">Home</a>
 
<li class="active"><a href="product">cancel</a>
</li></ul></div></nav>
<h2>PRODUCT DETAILS</h2><br>
<br>
 
<springForm:form action="addingproduct " method="post" modelAttribute="obprodjsp" enctype="multipart/form-data">
 
 <br>
  Car name:
  <br>
  <springForm:input type="text" path="pname" name="modelname" value="${obprodjsp.pname}" />
  <br>
   <br>
   <c:if test="${!empty obprodjsp.pid}">
  <springForm:input type="hidden" path="pid" name="carid" value="${obprodjsp.pid}"/>
   </c:if>
   <br>
   Price :
  <br>
  <springForm:input type="number" path="price" name="price" value="${obprodjsp.price}" />
  <br>
  <br>
  Stock availability:<br><br>
  
  <springForm:input type="text" path="stock" name="stock availaibility" value="${obprodjsp.stock}" />
  <br>
  <br><br>
 Product Discription:<br>
 <springForm:input type="text" path="description" value="${obprodjsp.description}" />
  <br>
  <br>
 <label>Category</label>
	<springForm:select path="category.cname"  items="${categoryList}" itemLabel="cname" itemValue="cname"></springForm:select>
<br>
  <br>
  <label>Supplier</label>
 <springForm:select path="supplier.sname" items="${supplierList}" itemLabel="sname" itemValue="sname"></springForm:select>
<br>
  <br>
  <label>Upload product image</label>
  <br>
  <springForm:input type="file" path="pimage" />
  <br>
<br> <c:if test="${empty obprodjsp.pname}">
 <button type="Submit">Add product</button>
 </c:if>
 <c:if test="${!empty obprodjsp.pname}">
 <button type="submit">Save</button>
  
 
 </c:if><br>
 </springForm:form> 
 <br>
 
<h2>Product Details in Table Formate </h2>
 <table style="width:100%">
  <tr>
   <th>Car Name</th>
    <th>Car id</th>
    <th>pimage</th>
    <th>Price</th>
    <th>Stock availaibility</th>
    <th>Product Discription</th>
  </tr>
  <c:forEach items="${Listofprod}" var="p">
  <tr>
    <td>${p.pname}</td>
    <td>${p.pid }</td>
    <td><img src="resources/images/${p.pid}.jpg" width="75" height="75"></td>
    <td>${p.price }</td>
    <td>${p.stock }</td>
    <td>${p.description }</td>
    <td><a href="updateproduct-${p.pid}"><button type="button" class="btn btn-primary">Update</button></a></td>
     <td><a href="deleteproduct-${p.pid }"><button type="button" class="btn btn-danger">Delete</button></a></td>
     
  </tr>
   </c:forEach>
</table>

 
</body>
</html>