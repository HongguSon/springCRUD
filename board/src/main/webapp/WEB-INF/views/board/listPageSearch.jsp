<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>

<div class="container">
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bno}</td>
				<td>
					<a href="/board/view?bno=${list.bno}">${list.title}</a>
				</td>
				<td>
					<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>${list.writer}</td>
				<td>${list.viewCnt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="col-md-offset-3">
	<div class="pagination justify-content-center">
		<c:if test="${page.prev}">
			<span class="page-item"><a class="page-link" href="/board/listPageSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">이전</a></span>
		</c:if>
		
		<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
			
				<c:if test="${select != num}"><span class="page-item"><a class="page-link" href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}">${num}</a></span></c:if>
				<c:if test="${select == num}"><span class="page-item active"><a class="page-link" href="#">${num}</a></span></c:if>
			
		</c:forEach>
		
		<c:if test="${page.next}">
			<span class="page-item"><a class="page-link" href="/board/listPageSearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}">다음</a></span>
		</c:if>
	</div>
	
	<hr />
	
	<div class="search row">
		<div class="col-xs-2 col-sm-2">
			<select name="searchType" class="form-control">
				<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
				<option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
				<option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
				<option value="writer" <c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
			</select>
		</div>
			
		<div class="col-xs-10 col-sm-10">
			<div class="input-group">
			<input type="text" name="keyword" value="${page.keyword}" class="form-control" />
			<span class="input-group-btn">
				<button type="button" class="btn btn-default" id = "searchBtn">검색</button>
			</span>
			</div>
		</div>
	</div>

</div>
</div>
<script type="text/javascript">
	document.getElementById("searchBtn").onclick = function () {
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword = document.getElementsByName("keyword")[0].value;
		
// 		console.log(searchType)
// 		console.log(keyword)
		location.href = "/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	}
</script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>