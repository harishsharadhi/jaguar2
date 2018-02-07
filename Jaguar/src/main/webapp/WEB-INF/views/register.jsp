 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JAGUAR</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<link  href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>"rel="stylesheet">
	<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
	<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
	
	<link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<form:form action="register" method="post" commandName="userDetail">
  <div class="container">
<div class="error" style="color: #ff0000;">${usernameError}${emailError}${userPhoneError }</div>
						
						
<c:if test="${not empty message}">
<div class="error" style="color: #ff0000;">${message}${usernameError}</div>
</c:if>


<label><b>UserName</b></label>
<form:errors path="username" cssStyle="color: #ff0000" />
<form:input type="text" placeholder="Enter UserName" path="name" required></form:input>


    <label><b>Email</b></label>
    <form:input type="text" placeholder="Enter Email" path="email" required></form:input>

    <label><b>Address</b></label>
    <form:input type="password" placeholder="Enter Address" path="address" required></form:input>

    <label><b>Repeat Password</b></label>
    <form:input type="password" placeholder="Repeat Password" path="password" required></form:input>
   
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

<label><b>PhoneNumber</b></label>
<form:input type="PhoneNumber" placeholder="Enter Phone Number" path="phone"></form:input>

    <div class="clearfix">
      <button type="button"  class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form:form>
</body>
</html>