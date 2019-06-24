<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	table {margin: 0 auto;}
	.td_submit, .td_title {text-align: center;}
	.td_title {border-top: 1px dotted black; padding-top: 10px;}
	.td_input {text-align: right;}
	.td_title {font-weight: bold;}
</style>
<body>
	<table>
		<form method="get" action="getPwById">
		<tr>
			<td class="td_title" colspan="2">
				아이디로 비밀번호 검색
			</td>
		</tr>
		<tr>
			<td>
				아이디 :
			</td>
			<td class="td_input">
				<input type="text" name="id">
			</td>			
		</tr>
		<tr>
			<td class="td_submit" colspan="2">
				<input type="submit" value="입력">
			</td>
		</tr>
		</form>
		<form method="get" action="getDataById">
		<tr>
			<td class="td_title" colspan="2">
				아이디로 비밀번호, 이름 검색
			</td>
		</tr>
		<tr>
			<td>
				아이디 :
			</td>
			<td class="td_input">
				<input type="text" name="id">
			</td>			
		</tr>
		<tr>
			<td class="td_submit" colspan="2">
				<input type="submit" value="입력">
			</td>
		</tr>
		</form>
		<form method="get" action="getIdByName">
		<tr>
			<td class="td_title" colspan="2">
				이름으로 아이디 검색
			</td>
		</tr>
		<tr>
			<td>
				이름 :
			</td>
			<td class="td_input">
				<input type="text" name="name">
			</td>			
		</tr>
		<tr>
			<td class="td_submit" colspan="2">
				<input type="submit" value="입력">
			</td>
		</tr>
		</form>
				<form method="get" action="getDataByName">
		<tr>
			<td class="td_title" colspan="2">
				이름으로 아이디, 비밀번호 검색
			</td>
		</tr>
		<tr>
			<td>
				이름 :
			</td>
			<td class="td_input">
				<input type="text" name="name">
			</td>			
		</tr>
		<tr>
			<td class="td_submit" colspan="2">
				<input type="submit" value="입력">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>
