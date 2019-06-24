<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.wrapper {text-align: center;}
	table {margin: 0 auto; border-collapse: collapse; border: 1px solid black;}
	td {border: 1px solid black;}
	.value {width: 100px;}
	.key {font-weight: bold;}
</style>
<body>
	<div class="wrapper">
		<c:choose>
			<c:when test="${result eq 'no_data'}">
				<h2>데이터가 없습니다.</h2>
				<button type="button" onclick="location.href='go_home'">돌아가기</button>
			</c:when>
			<c:when test="${result eq 'getPwById'}">
				<span><string>비밀번호</string>: ${pw}</span>
			</c:when>
			<c:when test="${result eq 'getDataById'}">
				<table>
					<tr>
						<td class="key">
							이름	
						</td>
						<td class="value">
							${name}
						</td>
					</tr>
					<tr>
						<td class="key">
							비밀번호
						</td>						
						<td class="value">
							${pw}
						</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${result eq 'getIdByName'}">
				<table>
				<c:forEach var="unit" items="${list}">
					<tr>
						<td class="key">
							아이디
						</td>
						<td class="value">
							${unit}
						</td>
					</tr>
				</c:forEach>
				</table>
			</c:when>
			<c:when test="${result eq 'getDataByName'}">
				<table>
				<c:forEach var="unit" items="${list}">
					<tr>
						<td class="key">
							아이디
						</td>						
						<td class="value">
							${unit.id}
						</td>
					</tr>
					<tr>
						<td class="key">
							비밀번호
						</td>						
						<td class="value">
							${unit.pw}
						</td>
					</tr>
				</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				ERROR
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>