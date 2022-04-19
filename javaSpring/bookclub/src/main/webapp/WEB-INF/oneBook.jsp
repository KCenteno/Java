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
 		<h1>${book.title}</h1>
 		<a href="/dashboard">dashboard</a>
		 	
	 		<c:choose>
	 			<c:when test="${user_id == book.user.id}">
				 	<p>You read ${book.title} by ${book.author}</p>
				 	<p>Here are your thoughts:</p>
				 	<br />
				 	<h4>${book.thoughts}</h4>
			 			<ul>
			 				<li><a class="btn btn-info" href="/editBook/${book.id}">Edit</a><a class="btn btn-danger" href="/delete/${book.id}">Delete</a></li>
			 			</ul>
	 			</c:when>
	 			<c:otherwise>
	 				<p>${book.user.name} read ${book.title} by ${book.author}</p>
				 	<p>Here are ${book.user.name}'s thoughts:</p>
				 	<br />
				 	<h4>${book.thoughts}</h4>
	 			</c:otherwise>
	 		</c:choose>
 		
    </div> <!-- End of Container -->
</body>
</html>