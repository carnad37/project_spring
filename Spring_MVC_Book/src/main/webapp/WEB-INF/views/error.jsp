<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:choose>
		<c:when test="error_word">
			<h2>
				잘못된 입력입니다.
			</h2>
		</c:when>
		<c:when test="error_data">			
			<h2>
				검색된 데이터가 없습니다.
			</h2>
		</c:when>
		<c:when test="error_number">
			<h2>
				숫자만 입력해주세요.
			</h2>
		</c:when>
		</c:choose>
	</div>
</body>
</html>