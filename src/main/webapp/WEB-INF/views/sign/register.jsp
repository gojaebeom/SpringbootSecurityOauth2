<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp"%>
<title>스터디북-회원가입</title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/WEB-INF/include/header.jsp"%>
	
	회원가입
	<form action="/register" method="post">
		<input name="account"><br>
		<input name="password" type="password"><br>
		<input name="name"><br>
		<input name="email"><br>
		<button type="submit">서브밋</button>
	</form>
</body>
</html>