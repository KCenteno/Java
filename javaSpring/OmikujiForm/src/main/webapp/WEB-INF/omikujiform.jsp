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
        <h1 class="text-center">Send an Omikuji!</h1>
        <form action="/processing" method="post">
          <div class="form-group">
            <label for="">Pick a number form 5 to 25</label>
            <input type="number" name="num" class="form-control text-center my-3">
          </div>
          <div class="form-group">
            <label for="">Enter the name of any city:</label>
            <input type="text" name="city" class="form-control text-center my-3">
          </div>
          <div class="form-group">
            <label for="">Enter the name of any real person</label>
            <input type="text" name="person" class="form-control text-center my-3">
          </div>
          <div class="form-group">
            <label for="">Enter professional endeavor or hobby:</label>
            <input type="text" name="hobby" class="form-control text-center my-3">
          </div>
          <div class="form-group">
            <label for="">Enter any type of living thing:</label>
            <input type="text" name="living" class="form-control text-center my-3">
          </div>
          <div class="form-group">
            <label for="">Say something nice to someone:</label>
            <textarea name="nice" cols="30" rows="10" class="form-control text-center my-3"></textarea>
          </div>
          <input type="submit" value="Submit" class="btn btn-success mt-3">
        </form>
    </div> <!-- End of Container -->
</body>
</html>