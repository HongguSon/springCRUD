<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div id="nav">
 <%@ include file="./include/nav.jsp" %>
</div>
<div class="container">
<h2>
환영합니다!
</h2>
<br/><br/>
<c:if test="${member == null}">
<form role="form" method="post" autocomplete="off" action="/member/login">
	<p>
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId" />
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="userPass" />
	</p>
	<div class="">
		<button type="submit" class="btn btn-light">로그인</button>
		<div class="btn btn-light"><a href="/member/register" style="text-decoration:none;">회원가입</a></div>
	</div>
</form>
</c:if>
<c:choose>
	<c:when test="${member != null}">
		<p>${member.userName}님 환영합니다.</p>
		<a href="member/logout">로그아웃</a>
		<a href="member/memberModify">비밀번호 변경</a>
	</c:when>
	<c:otherwise>
		<p>로그인 해주세요.</p>
	</c:otherwise>
</c:choose>
<c:if test="${msg==false}">
	<p style="color:#f00;">로그인에 실패했습니다. ID & PW를 다시 확인해 주세요.</p>
</c:if>
</div>
</body>
</html>
