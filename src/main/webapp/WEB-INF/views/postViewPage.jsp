<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 선택 해서 보는 페이지</title>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/postViewPage.js"></script>
<link rel="stylesheet" href="/resources/css/postViewPage.css">
</head>
<body>
	<div><!-- 특정 글 보는 뷰 DIV START-->
		<h1>제목 :</h1>
		<span id="post_title"> </span>

		<h1>내용</h1>
		<span id="post_content"> </span>

		<div><!-- 버튼 DIV START-->
			<!-- 글 삭제 버튼-->
			<input type="button" id="delPost" value="삭제" />

			<!-- 글 수정 버튼-->
			<input type="button" id="editPost" value="수정" />
		</div><!--버튼 DIV END-->

	</div><!-- 특정 글 보는 뷰 DIV END-->
</body>
</html>