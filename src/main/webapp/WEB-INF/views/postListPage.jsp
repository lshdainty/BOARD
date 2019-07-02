<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트 페이지</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/postListPage.js"></script>
<link rel="stylesheet" href="resources/css/postListPage.css">
</head>
<body>
	<div id="table_div"> <!-- table DIV START-->
        <table id="post_table">
            <thead>
                <tr class="thead_tr">
                    <th id="post_code">POST_CODE</th>
                    <th id="post_title">POST_TITLE</th>
                    <th id="id">ID</th>
                    <th id="post_date">POST_DATE</th>
                </tr>
            </thead>
            
            <tbody id="tbody">
            </tbody>
        </table>
    </div> <!-- table DIV END-->

    <div> <!-- 글 쓰기 DIV START -->
        <input type="button" id="writePost" value="글 쓰기"/>
    </div>  <!-- 글 쓰기 DIV END -->
</body>
</html>