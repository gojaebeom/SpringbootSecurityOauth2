<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp"%>
<title>스터디북-로그인</title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/WEB-INF/include/header.jsp"%>
	
	<form action="/login" method="post">
		<label>아이디</label><br> 
		<input name="account"><br> 
		<label>비밀번호</label><br>
		<input name="password" type="password"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>