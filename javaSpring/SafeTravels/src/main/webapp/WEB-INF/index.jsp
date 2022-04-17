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
 		<h1>Save Travels</h1>
 		<br />
 		<br />
 		<table class="table table-dark table-striped table hover">
      <thead>
        <tr>
          <th class="align-middle">Expense</th>
          <th class="align-middle">Vendor</th>
          <th class="align-middle">Amount</th>
          <th class="align-middle">Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="i" items="${allPlans}">
          <tr>
            <td>
              <a href="/onePlan/${i.id}"><c:out value="${i.expense}"></c:out></a>
            </td>
            <td><c:out value="${i.vendor}"></c:out></td>
            <td>$<c:out value="${i.amount}"></c:out></td>
            <td>
              <a class="btn btn-primary" href="/updatePlan/${i.id}">Update This Plan</a>
              <a class="btn btn-danger" href="/delete/${i.id}">Delete The Plan</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    </div> <!-- End of Container -->
    <div class="container p-5 my-3 bg-dark text-white text-center">
    <h1>Add a Plan:</h1>
    <form:form action="/processPlan" method="post" modelAttribute="travelPlan">
      <p>
          <form:label path="expense">Expense</form:label>
          <form:input path="expense"/>
          <form:errors class="alert-danger" path="expense" />
      </p>
      <p>
          <form:label path="vendor">Vendor</form:label>
          <form:input path="vendor"/>
          <form:errors class="alert-danger" path="vendor"/>
      </p>
      <p>
          <form:label path="amount">Amount</form:label>
          <form:input type="number" step="0.01" path="amount"/>
          <form:errors class="alert-danger" path="amount" />
      </p>
      <p>
          <form:label path="description">Description</form:label>
          <form:input type="text" path="description"/>
          <form:errors class="alert-danger" path="description"/>
      </p>
      <br />
      <br />
      <input type="submit" value="Submit"/>
  	</form:form>
    </div>
</body>
</html>