<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>
<div class="container">
<form role="form" method="post" autocomplete="off" onsubmit="return check();">
	<p>
		<label for="userId">아이디</label>
		<input type="text" id="userId" value="${member.userId}" readonly="readonly" name="userId" />
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="userPass" />
	</p>
	<p>
		<label for="userName">닉네임</label>
		<input type="text" id="userName" value="${member.userId}" readonly="readonly" name="userName" />
	</p>
	<div class="">
		<button type="submit" class="btn btn-light">회원 탈퇴</button>
	</div>
	<p><a href="/">처음으로</a></p>
</form>
<c:if test="${msg==false}">
<p>입력한 비밀번호가 잘못되었습니다. 다시 입력해주세요.</p>
</c:if>
</div>
</body>
</html>