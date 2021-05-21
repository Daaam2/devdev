<%@page import="com.dev.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id"> &nbsp;
		<input type="hidden" name="job" value="update">
		<input type="submit" value="조회">
	</form>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null) {
			// 입력화면
			%>
			<form action="memberUpdate.do" method="post">
				아이디 : <input type="text" name="id" value="<%=member.getId() %>"> <br>
				비번 : <input type="password" name="pwd" value="<%=member.getName() %>"> <br>
				이름 : <input type="text" name="name" value="<%=member.getName() %>"> <br>
				메일 : <input type="email" name="mail" value="<%=member.getMail() %>"> 
				<input type="submit" value="수정">
			</form>
			<%
		} else {
			%>
			<h3>응아니야~</h3>
			<%
		}
	%>
	
</body>
</html>