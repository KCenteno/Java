<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container p-5 my-3 bg-dark text-white text-center"> <!-- Beginning of Container -->
 		
 		<h1>Make a Candy Owner?</h1>
 		<br />
 		
 		<h1>New Owner form:form</h1>
    <form:form action="/processOwner" method="post" modelAttribute="owner">
      <p>
          <form:label path="firstName">First Name</form:label>
          <form:input path="firstName"/>
          <form:errors class="alert-danger" path="firstName" />
      </p>
      <p>
          <form:label path="lastName">Last Name</form:label>
          <form:input path="lastName"/>
          <form:errors class="alert-danger" path="lastName"/>
      </p>
      <input type="submit" value="Submit"/>
  </form:form>
 		
 		<a href="/dashboard">Dashboard</a>

 		
    </div> <!-- End of Container -->
</body>
</html>