<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInsert.jsp</title>
</head>
<body>
<h3>회원가입</h3>
<form action="memberInsert.do" method="post">
<!-- action="*.do"로 끝나게!(web.xml설정) -->
	아이디 : <input type="text" name="id"> <br>
	비번 : <input type="password" name="pwd"> <br>
	이름 : <input type="text" name="name"> <br>
	메일 : <input type="email" name="mail"> 
	<input type="submit" value="등록">
</form>
</body>
</html>