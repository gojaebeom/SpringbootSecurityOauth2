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
	
	<section class="section">
		<form action="/login" method="post" class="form">
			<div class="form-input-wrap">
				<label for="account">아이디</label>
				<input id="account" name="account" placeholder="영문 대소문자 또는 숫자를 포함한 총 4-15자리 입력">
			</div>
			<div class="form-input-wrap">
				<label for="password">비밀번호</label>
				<input id="password" name="password" type="password" placeholder="최소 8글자 이상, 특수문자1개 이상을 포함">
			</div>
			<div class="form-input-wrap">
				<label for="name">이름</label>
				<input id="name" name="name" placeholder="이름 또는 닉네임을 입력해주세요">
			</div>
			<div class="form-input-wrap">
				<label for="email">이메일</label>
				<input id="email" name="email" placeholder="시용가능한 email을 입력해주세요">
			</div>
			<br>
			<span class="message-span"></span>
			<button type="submit">회원가입</button>
			<br>
			<span>
				이미 계정을 가지고 계신가요? 바로 <a href="/login" class="form-info-text">로그인</a> 하세요.
			</span>
		</form>
	</section>
</body>
</html>