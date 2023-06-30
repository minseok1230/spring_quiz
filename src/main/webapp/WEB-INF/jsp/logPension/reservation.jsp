<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<!-- 내가만든 스타일시트 -->
<link href="/css/logPension/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
            	<li class="nav-item"><a href="#" class="nav-link top-menu-font">팬션소개</a></li>
            	<li class="nav-item"><a href="#" class="nav-link top-menu-font">객실보기</a></li>
            	<li class="nav-item"><a href="#" class="nav-link top-menu-font">예약하기</a></li>
            	<li class="nav-item"><a href="#" class="nav-link top-menu-font">예약목록</a></li>
            </ul>
		</nav>
		<div class="contents">
			<div class="d-flex justify-content-center">
				<h2 class="mt-2 font-weight-bold">예약 하기</h2>
			</div>
			<div class="form-group d-flex justify-content-center w-100">
				<div class="w-50">
					<span>이름</span>
					<input type="text" class="form-control">
					<span>예약날짜</span>
					<input type="text" class="form-control">
					<span>숙박일수</span>
					<input type="text" class="form-control">
					<span>숙박인원</span>
					<input type="text" class="form-control">
					<span>전화번호</span>
					<input type="text" class="form-control">
					<button type="button" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
			
			
		</div>
		<footer>
			<div class="text-secondary ml-3">
				<small>제주특별자치도 제주시 애월읍</small><br>
				<small>사업자등록번호: 111-22-255222 / 농어촌민박사업자지정/대표:김통목</small><br>
				<small>Copyright 2025 tongnamu. All right reserved</small>
			</div>
		</footer>
		
	</div>

</body>
</html>