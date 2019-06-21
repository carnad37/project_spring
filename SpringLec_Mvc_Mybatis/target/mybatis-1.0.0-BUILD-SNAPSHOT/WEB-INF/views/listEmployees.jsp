<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	
	<h3>List of Employees</h3>
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Department</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">

			<tr>
				<td width="60" align="center">${employee.id}</td>
				<td width="60" align="center">${employee.name}</td>
				<td width="60" align="center">${employee.age}</td>
				<td width="60" align="center">${employee.dept}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>