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
<title>Fruity</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container text-center"> <!-- Beginning of Container -->
        <h1>Fruit Store</h1>
        	<table class="table">
        		<tbody>
        			<tr>
        				<th>Name</th>
        				<th>Price</th>
        			</tr>
        					<c:forEach var="fruits" items="${fruitsfromcontrollers}">
        			<tr>
        				<td><c:out value="${fruits.name}"/></td>
        				<td>$<c:out value="${fruits.price}"/></td>
        			</tr>
							</c:forEach>
        		</tbody>
        	</table>
    </div> <!-- End of Container -->
</body>
</html>