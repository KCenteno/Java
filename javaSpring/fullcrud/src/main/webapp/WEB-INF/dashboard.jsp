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
 		
 		<h1>All the Candies</h1>
 		<a href="/logout" class="btn btn-danger">logout</a>
 		<a href="/newCandy" class="btn btn-info">New Candy</a>
 		<a href="/newOwner" class="btn btn-info">make an Owner</a>
 		
 		
    <table class="table table-dark table-striped table hover">
      <thead>
        <tr>
          <th class="align-middle">Name</th>
          <th class="align-middle">Brand</th>
          <th class="align-middle">Price</th>
          <th class="align-middle">Rating</th>
          <th class="align-middle">Actions</th>
          <th class="align-middle">Owner</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="i" items="${allCands}">
          <tr>
            <td>
              <a href="/oneCandy/${i.id}"><c:out value="${i.name}"></c:out></a>
            </td>
            <td><c:out value="${i.brand}"></c:out></td>
            <td><c:out value="${i.price}"></c:out></td>
            <td><c:out value="${i.rating}"></c:out></td>
            <td>
              <a class="btn btn-primary" href="/updateCandy/${i.id}">Update This Candy</a>
              <a class="btn btn-danger" href="/delete/${i.id}">Delete</a>
            </td>
            <td> <c:out value="${i.owner.firstName} ${i.owner.lastName}"></c:out></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    
    </div> <!-- End of Container -->
</body>
</html>