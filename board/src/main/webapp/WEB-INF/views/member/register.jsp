<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>
<div class="container">
<form role="form" method="post" autocomplete="off" onsubmit="return check();">
	<p>
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId" />
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="userPass" />
	</p>
	<p>
		<label for="userName">닉네임</label>
		<input type="text" id="userName" name="userName" />
	</p>
	<div class="">
		<button type="submit" class="btn btn-light">회원가입</button>
	</div>
	<p><a href="/">처음으로</a></p>
</form>
</div>

<script>
	function check() {
		if(document.getElementById("userId").value.replace(/\s/g, "") == ""){
			alert("ID를 입력하세요");
			return false;
		} else if(document.getElementById("userPass").value.replace(/\s/g, "") == ""){
			alert("PW를 입력하세요");
			return false;
		} else if(document.getElementById("userName").value.replace(/\s/g, "") == ""){
			alert("닉네임을 입력하세요");
			return false;
		} else {
			return true;
		}
		
	}
</script>
</body>
</html>