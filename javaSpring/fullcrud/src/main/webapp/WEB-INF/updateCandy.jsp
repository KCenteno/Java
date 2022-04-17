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
 		
 		<h1>What changes would you like to make to this Candy?</h1>

     <form:form action="/updatingCandy/${candy.id}" method="post" modelAttribute="candy">
      
      <input type="hidden" name="_method" value="put">
      <p>
          <form:label path="name">Name</form:label>
          <form:errors class="alert-danger" path="name"/>
          <form:input path="name"/>
      </p>
      <p>
          <form:label path="brand">Brand</form:label>
          <form:errors class="alert-danger" path="brand"/>
          <form:textarea path="brand"/>
      </p>
      <p>
          <form:label path="price">Price</form:label>
          <form:errors class="alert-danger" path="price"/>
          <form:input type="number" step="0.01" path="price"/>
      </p>
      <p>
          <form:label path="rating">Rating</form:label>
          <form:errors class="alert-danger" path="rating"/>
          <form:input type="number" path="rating"/>
      </p>
      <form:select path="owner">
      	<c:forEach var="i" items="${allOwners}">
     		<form:option value="${i.id}">${i.firstName} ${i.lastName}</form:option>
      	</c:forEach>
	  </form:select>
      <input type="submit" value="Submit"/>
  </form:form>
 		
 		<a href="/dashboard">Dashboard</a>
 		<a href="/newCandy">New Candy</a>
 		
    </div> <!-- End of Container -->
</body>
</html>