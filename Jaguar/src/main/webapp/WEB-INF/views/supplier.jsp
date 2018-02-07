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
 
<li class="active"><a href="supplier">cancel</a>
</li></ul></div></nav>
<h2>SUPPLIER DETAILS</h2><br>
<br>
 <springForm:form action="addingsupplier" method="post" modelAttribute="obsupjsp">
 <springForm:input type="hidden" path="sid" value="${obsupjsp.sid}"/>
  Supplier Name:
  <br>
  <springForm:input type="text" path="sname" name="supplier name" value="${obsupjsp.sname}"/>
 <br>
 <br>
 <c:if test="${empty obsupjsp.sname}">
 <button type="Submit">Add supplier to list</button>
 </c:if>
 <c:if test="${!empty obsupjsp.sname}">
 <button type="submit">Edit</button>
 </c:if>
 </springForm:form>
 
 
 <h2>Supplier Details in Table Formate </h2>
 <table class="table">
  <tr>
   <th>sid</th>
    <th>sname</th>
  </tr>
  <c:forEach items="${listofsupp}" var="s">
  <tr>
  <td>${s.sid }</td>
    <td>${s.sname}</td>
    <!-- //crud operation begining// -->
     <td><a href="updatesupplier-${s.sid}"><button type="button" class="btn btn-primary">Update</button></a></td>
     <td><a href="deletesupplier-${s.sid }"><button type="button" class="btn btn-danger">Delete</button></a></td>
     
  </tr>
   </c:forEach>
</body>
</html>