<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="post-form-background" class="post-background-wrap">
	<form id="post-form" class="form post-form">
		<div class="post-form-header">
			<h1>게시물 작성</h1>
			<i id="close-post-button" class="ri-close-circle-fill close-button"></i>
		</div>
		<div class="form-input-wrap">
			<label for="title">제목</label>
			<input id="title" name="title">
		</div>
		<div class="form-input-wrap">
			<label for="content">내용</label>
			<div id="editor"></div>
		</div>
	</form>
</div>