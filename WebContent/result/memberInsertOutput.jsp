<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberInsertOutput.jsp</title>
</head>
<body>
	<h3>가입완료!</h3>
	<p>${member.name }님 환영함둥!!</p>
	<p>ID : ${member.id }</p>
	<p>Mail : ${member.mail }</p><br>
	<a href="Index.jsp"> back! </a>
</body>
</html>