<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색 결과</title>
</head>
<body>
	<table>
		<c:choose>
			<c:when test="getDataByCheckOuted">
				<c:forEach var="unit" items="${list}">
				<tr>
					<td>
						도서 번호 : 	
					</td>
					<td>
						${unit.bookNum}
					</td>
				</tr>
				<tr>
					<td>
						도서명 :
					</td>
					<td>
						${unit.name}
					</td>
				</tr>
				<tr>
					<td>
						저자 : 
					</td>
					<td>
						${unit.author}
					</td>
				</tr>
				<tr>
					<td>
						출판사 : 
					</td>
					<td>
						${unit.publisher}
					</td>
				</tr>
				<tr>
					<td>
						가격 : 
					</td>
					<td>
						${unit.price}
					</td>
				</tr>
				<tr>
					<td>
						대여 여부 : 
					</td>
					<td>
						<c:if test="${unit.checkOuted}">
							대여 불가
						</c:if>
						<c:if test="${!unit.checkOuted}">
							대여 가능
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:when test="getNameByPriceOver">
			
			</c:when>
			<c:when test="getNameANDCheckOutedByBookNum">
			
			</c:when>
			<c:when test="getPublisherByAuthor">
			
			</c:when>
			
			<c:otherwise>
				JSP_ERROR(ohterwise)
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>