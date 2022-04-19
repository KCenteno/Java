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
 		<h1>Welcome ${user.name}</h1>
 		<p>Books from everyone's shelves:</p>
 		<a href="/logout" class="btn btn-warning">Logout</a>
 		<a href="/books" class="btn btn-info">+ Add a Book to my shelf!</a>
 		<table class="table table-dark table-striped table-hover">
      <thead>
        <tr>
          <th class="align-middle">Id</th>
          <th class="align-middle">Title</th>
          <th class="align-middle">Author</th>
          <th class="align-middle">Posted By</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="i" items="${allBooks}">
          <tr>
            <td><c:out value="${i.id}"></c:out></td>
            <td>
              <a href="/books/${i.id}"><c:out value="${i.title}"></c:out></a>
            </td>
            <td><c:out value="${i.author}"></c:out></td>
            <td><c:out value="${i.user.name}"></c:out></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    </div> <!-- End of Container -->
</body>
</html>