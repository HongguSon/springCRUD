<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>게시물 작성</title>
</head>
<body>

<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>
<div class="container">
	<c:if test="${msg == null}">
		<form method="post">
		
		<label>제목</label>
		<input type="text" name="title" /><br />
		<label>작성자</label>
		<input type="text" name="writer" value="${member.userName}" readonly="readonly" /><br />
		<label>내용</label>
		<textarea cols="50" rows="5" name="content"></textarea><br />
		
		<button type="submit">작성완료 및 저장</button>
		
		</form>
	</c:if>
	<c:if test="${msg == false}">
		<p>로그인을 하고 글을 작성하세요.</p>
		<p><a href="/">홈으로</a></p>
	</c:if>
</div>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>