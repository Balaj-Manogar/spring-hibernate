<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
</head>
<body>
<h3>Employees list</h3>
AA::${employeeList}::BBB
<table>
<tr><td>Employee No</td><td>Employee name</td></tr>
<c:forEach items="${employeeList}" var="employee">
	<tr><td>${employee.employeeNumber}</td><td>${employee.firstName}&nbsp;${employee.lastName}</td></tr>
</c:forEach>
</table>
</body>
</html>