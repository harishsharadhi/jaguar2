<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
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
 
 <li class="active"><a href="category">cancel</a>
</li></ul></div></nav>
<h2>CATEGORY DETAILS</h2><br>
<br>
<springForm:form action="addingcategory " method="post" modelAttribute="obcatjsp">
 
  Car Model name:
  <br>
  <springForm:input type="text" path="cname" name="car model name" value="${obcatjsp.cname}"/>
  <br>
  <br>
   <springForm:input type="hidden" path="cid" name="car id" value="${obcatjsp.cid }"/>
  <br>
  <br>
  Features of model:
  <br>
  <springForm:input type="text" path="cfeaturesofmodel" name="features of model" value="${obcatjsp.cfeaturesofmodel} "/>
  
  <br>
  <br>
  <br> 
  
 <br> <c:if test="${empty obcatjsp.cname}">
 <button type="Submit">Add category</button>
 </c:if>
 <c:if test="${!empty obcatjsp.cname}">
 <button type="submit">Save</button>
 </c:if><br>
 </springForm:form> 
 
 <br>
 <h2>Category Details in Table Formate </h2>
 <table style="width:100%">
  <tr>
   <th>Cid</th>
    <th>Car model name</th>
    <th>Features of model</th>
  </tr>
  <c:forEach items="${Listofcat}" var="c">
  <tr>
    <td>${c.cname}</td>
    <td>${c.cid }</td>
    <td>${c.cfeaturesofmodel}</td>
   <!--  //crud operation begins -->
    <td><a href="updatecategory-${c.cid}"><button type="button" class="btn btn-primary">Update</button></a></td>
     <td><a href="deletecategory-${c.cid }"><button type="button" class="btn btn-danger">Delete</button></a></td>
     
  </tr>
   </c:forEach>
   
</table>
</body>
</html>