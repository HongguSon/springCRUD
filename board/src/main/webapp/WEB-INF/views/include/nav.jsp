<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br/><br/><br/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>    
<div class="container">

<div class="page-header"><h1>게시판</h1></div>
<hr />
<ul class="nav nav-pills nav-fill"> 
<!--  <li class="nav-item"> -->
<!--   <a href="/board/list">글 목록</a>  -->
<!--  </li> -->

 <li class="nav-item">
  <a href="/board/listPageSearch?num=1">글 목록</a> 
 </li>
 
<!--  <li class="nav-item"> -->
<!--   <a href="/board/listPage?num=1">글 목록(Pagination)</a>  -->
<!--  </li> -->
 
 <li class="nav-item">
  <a href="/board/write">글 작성</a> 
 </li> 
 <li class="nav-item">
  <a href="/">홈으로</a> 
 </li> 
</ul>
<hr />
</div>