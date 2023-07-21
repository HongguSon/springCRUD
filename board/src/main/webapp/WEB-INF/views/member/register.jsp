<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
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
		<button type="button" class="idCheck btn btn-light">아이디 중복 확인</button>
		<span class="msg">중복 확인을 해주세요.</span>
	</p>
	
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="userPass" />
	</p>
	<p>
		<label for="userName">닉네임</label>
		<input type="text" id="userName" name="userName" autocomplete="off" />
	</p>
	<div class="">
		<button type="submit" id="submit" class="btn btn-light" disabled="disabled">회원가입</button>
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
	
	$(".container .idCheck").click(function(){
		var query = {userId : $("#userId").val()};
		
		$.ajax({
			url : "/member/idCheck",
			type : "post",
			data : query,
			success : function(data) {
				if(data==1){
					$(".container .msg").text("사용 불가");
					$(".container .msg").attr("style", "color:#f00")
					$("#submit").attr("disabled", "disabled")
				} else {
					$(".container .msg").text("사용 가능");
					$(".container .msg").attr("style", "color:#00f")
					$("#submit").removeAttr("disabled")
				}
			}
		});
		
		$("#userId").keyup(function(){
			
			$(".container .msg").text("아이디를 확인해주십시오.");
			$(".container .msg").attr("style", "color:#000");
			$("#submit").attr("disabled", "disabled");
			
		})
	});
</script>
</body>
</html>