<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
    
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
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/3.3.7/css/font-awesome.min.css" rel="stylesheet"> 
<title>SAROVARA MODEL</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>Jaguar</title>

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
<li class="active"><a href="loginpage">save</a>
<li class="active"><a href="user">cancel</a>
</li></ul></div></nav>
<br>
<h2>PLS PROVIDE YOUR INFORMATION BELOW...</h2>
<br>
<springForm:form action="userrequest" method="post" modelAttribute="obuserjsp">
  user name: 
  <br>
  <springForm:input type="text" path="name" name="username" value="" />
  <br>
  <br>
 user id:
 <br>
  <springForm:input type="text" path="userId" name="id" value="" />
  <br>
  <br>
 Email:
 <br>
   <springForm:input type="text" path="email" name="email" value="" />
  <br>
  <br>
  password:
  <br>
  <springForm:input type="password" path="password" name="password" value=""/>
  <br>
  <br>
  Phone:
   <br>
   <springForm:input type="number" path="phone" name="phone" value=""/>
  <br>
  <br>
  <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other  
  <br>
  <br>
  Role:
  <br>
   <springForm:input type="text" path="role" name="role" value=""/>
  <br>
  <br>
  Address:
   <br>
   <springForm:input type="text" path="address" name="address" value=""/>
  <br>
  <br>  
 <springForm:button type="submit">Add </springForm:button>
          
</springForm:form>



 </body>
 </html>

