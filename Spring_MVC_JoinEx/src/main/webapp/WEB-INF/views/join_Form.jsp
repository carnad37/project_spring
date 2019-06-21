<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Home</title>
</head>
<style>
	* {padding: 0; margin: 0;}
	div {box-sizing: border-box;}
	div.wrapper {border-radius:5px; width: 400px; margin: 20px auto; padding: 10px 25px; background-color: rgb(156, 188, 44);}
	ul {list-style: none; width:350px;}
	input {border-radius: 2px; height: 25px; border: none;}
	li {border-radius: 3px; border: 2px solid rgb(227, 236, 196); background-color: rgb(186, 208, 108);  margin: 2px 0; text-align: left; padding: 10px 10px 10px 10px}
	span.title {width: 100px; display: inline-block; font-size: 14px;}
	h4 {color: rgb(56, 67, 60); margin: 10px 0;}
	button {
		color: white; font-size: 16px; font-weight: lighter;
		background-color: rgb(56, 67, 19);
		border: none; padding: 5px 25px 9px 25px;
		border-radius: 20px; margin: 10px auto;
		display: block;}
</style>
<body>
	<form action="sign_up" method="get">
		<div class="wrapper">
			<h4>Step 1 : 로그인 정보</h4>
			<ul>
				<li>
					<span class="title">아이디</span>
					<input type="text" name="id" >	
				</li>
				<li>
					<span class="title">비밀번호</span>
					<input type="text" name="pw">		
				</li>
				<li>
					<span class="title" id="">비밀번호 확인</span>
					<input type="text" name="pw_check" >		
				</li>
			</ul>
			<h4>Step 2 : 개인 정보</h4>
			<ul>
				<li>
					<span class="title">이름</span>
					<input type="text" name="name" id="name" placeholder=" 5자미만 공백없이">	
				</li>
				<li>
					<span class="title">메일 주소</span>
					<input type="text" name="email" placeholder=" email@domain.com">		
				</li>
				<li>
					<span class="title">연락처 </span>
					<input type="text" name="phone" placeholder=" - (하이픈)없이 입력">		
				</li>
			</ul>
			<button type="submit">제출</button>			
		</div>
	</form>
</body>
</html>
