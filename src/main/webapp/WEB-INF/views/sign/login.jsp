<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${ not empty sessionScope.login }">
	<script>
		alert('이미 로그인 되어 있습니다 🤨');
		location.href="/"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp"%>
<title>스터디북-로그인</title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/WEB-INF/include/header.jsp"%>
	
	<section class="section">
		<form action="/login" method="post" class="form">
			<div class="form-input-wrap">
				<label for="account">아이디</label>
				<input id="account" name="account">
			</div>
			<div class="form-input-wrap">
				<label for="password">비밀번호</label>
				<input id="password" name="password" type="password">
			</div>
			<div class="form-checkbox-wrap">
				<input id="remember" name="remember" type="checkbox">
				<label for="remember">아이디 기억하기</label>
			</div>
			<span class="message-span"></span>
			<button type="submit">로그인</button>
			<br>
			<span>
				 <a href="/register" class="form-info-text">비밀번호를 잊으셨나요?</a>
			</span>
			<br>
			<hr>
			<br>
			<span>
				계정이 없으신가요? 먼저 
				<a href="/register" class="form-info-text">회원가입</a>을 진행하세요.
			</span><br>
		</form>
	</section>
	
	<script defer="defer" type="module" src="/static/js/validation/loginValidation.js"></script>
</body>
</html>