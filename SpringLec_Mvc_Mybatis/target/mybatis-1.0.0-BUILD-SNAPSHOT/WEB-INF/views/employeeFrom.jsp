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
	<h3>Add / Edit Employee!!!</h3>

	
	<form action="employee" method="get">
		id : <input type="text" name="id"> <br />
		name : <input type="text" name="name"> <br />
		age : <input type="text" name="age"> <br />
		dept : <input type="text" name="dept"> <br />
		<input type="submit" value="전송">
	</form>

	
	<br>
	
</body>
</html>