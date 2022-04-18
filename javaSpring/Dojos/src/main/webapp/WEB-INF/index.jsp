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
	<div class="container p-5 my-3 bg-dark text-white text-center">
	<h1>Here's a List off all the Dojos</h1>
	<table class="table table-dark table-striped table-hover">
      <thead>
        <tr>
          <th class="align-middle">Dojos</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="i" items="${allDojos}">
          <tr>
            <td><a href="/dojos/${i.id}"><c:out value="${i.name}"></c:out></a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
	</div>
    <div class="container p-5 my-3 bg-dark text-white text-center"> <!-- Beginning of Container --> 		
 		<h1>Got a Dojo name? Click <a href="/dojos/new">Here</a> To Make it come true.</h1>
 		<br />
 		<br />
 		<h1>If you would like to register for a Dojo thats already made. Click <a href="/ninjas/new">Here</a></h1>
    </div>
</body>
</html>