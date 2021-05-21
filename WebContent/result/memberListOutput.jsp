<%@page import="com.dev.VO.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원목록!</h3>
	<c:choose>
		<c:when test="${empty list }">
			<p>조회결과없음!</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${list }" var="member">
					<li>${member.id } - ${member.name } </li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href="Index.jsp"> back! </a>
	
	<%--
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	if(list.size() == 0) {
		// 결과 없음!
	} else {
		// 회원리스트 화면
		
		for(MemberVO member : list) {
			
		}
	}
	--%>
</body>
</html>