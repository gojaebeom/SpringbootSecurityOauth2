<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${ empty sessionScope.login }">
	<script>
		alert('비정상적인 접근입니다 🤨');
		location.href="/"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp"%>
<title>스터디북-게시물 생성</title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/WEB-INF/include/header.jsp"%>
	
	<section class="section">
		<form id="post-form" class="form post-form">
			<div class="post-form-header">
				<h1>게시물 작성</h1>
			</div>
			<div class="form-input-wrap">
				<label for="title">제목</label>
				<input id="title" name="title">
			</div>
			<div class="form-input-wrap">
				<label for="content">내용</label>
				<textarea id="editor" name="content"></textarea>
			</div>
			
			<button type="submit">생성</button>
		</form>
	</section>
</body>
</html>