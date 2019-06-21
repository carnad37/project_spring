<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="/main/board/view" method="get">
		<span>id : </span><input name="id" type="text"> <br>
		<span>pw : </span><input name="pw" type="text"> <br>
		<input type="submit" value="submit">
	</form>
</body>
</html>
