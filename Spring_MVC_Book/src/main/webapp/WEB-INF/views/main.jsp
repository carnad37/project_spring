<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookSearch</title>
</head>
<body>
	<table>
		<form method="get" action="#">
		<tr>
			<td colspan="2">
				checkOuted의 상태로 검색
			</td>
		</tr>
		<tr>
			<td>
				checkOuted
			</td>
			<td>
				<input type="text" name="">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="submit">
			</td>
		</tr>
		</form>
		<form method="get" action="#">
		<tr>
			<td colspan="2">
				price로 name을 검색
			</td>
		</tr>
		<tr>
			<td>
				price
			</td>
			<td>
		<input type="text" name="">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="submit">
			</td>
		</tr>
		</form>		
		<form method="get" action="#">
		<tr>
			<td colspan="2">
				bookNum으로 name, checkOuted을 검색 
			</td>
		</tr>
		<tr>
			<td>
				bookNum
			</td>
			<td>
		<input type="text" name="">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="submit">
			</td>
		</tr>
		</form>
		<form method="get" action="#">
		<tr>
			<td colspan="2">
				author에 포함된 문자로 publisher를 검색 
			</td>
		</tr>
		<tr>
			<td>
				author
			</td>
			<td>
				<input type="text" name="">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="submit">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>