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
    <div class="container p-5 my-5 bg-dark text-white"> <!-- Beginning of Container -->
        <h1 class="text-center">Here's Your Omikuji!</h1>
        <p class="text-center mt-5">In <%= session.getAttribute("num") %> years, you will live in <%= session.getAttribute("city") %> with <%= session.getAttribute("person") %> as your roomate, <%= session.getAttribute("hobby") %> for a living. The next time you see a <%= session.getAttribute("living") %>, you will have good luck. Also, <%= session.getAttribute("nice") %></p>
    </div> <!-- End of Container -->
    <div class="text-center">
      <a href="/clear" class="btn btn-primary text-center">Go Back</a>
    </div>
</body>
</html>