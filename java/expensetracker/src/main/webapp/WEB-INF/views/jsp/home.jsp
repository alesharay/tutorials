<%@ page language="java" contentType="text.html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>expensetracker</title> 
  </head>
  <body>
    <h1>Expense Tracker</h1>
    <p>${message}</p> 
    
    <c:forEach var="expense" items="${expenses}">
      <div>
        <h3>${expense.expensename}</h3>
        <p>&#0024;${expense.amount}</p>
      </div>
    </c:forEach>
  </body>
</html>