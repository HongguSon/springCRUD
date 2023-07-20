<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
<form role="form" method="post" autocomplete="off">
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
</div>
</body>
</html>
