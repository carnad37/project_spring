<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
	<style>
		ul
		{
			list-style-type : none;
		}
	</style>
</head>
<body>
<form method="get" action="changePw" >
 <ul>
 
ID : ${member.id} <br />
PW : ${member.pw}
   <li>pw</li>
   <li><input type="text" name="pw" value="banana"></input></li>
   <li><input type="submit" value="change"></input></li>
 </ul>
</form>
</body>
</html>

