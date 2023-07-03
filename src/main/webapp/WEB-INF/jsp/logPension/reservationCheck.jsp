<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인</title>
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
            	<li class="nav-item"><a href="http://localhost:8080/logPension/reservation_check_view" class="nav-link top-menu-font">팬션소개</a></li>
            	<li class="nav-item"><a href="#" class="nav-link top-menu-font">객실보기</a></li>
            	<li class="nav-item"><a href="http://localhost:8080/logPension/reservation_view" class="nav-link top-menu-font">예약하기</a></li>
            	<li class="nav-item"><a href="http://localhost:8080/logPension/reservation_list_view" class="nav-link top-menu-font">예약목록</a></li>
            </ul>
		</nav>
		<div class="contents">
			<div>
				<img src="/image/logPension/test06_banner1.jpg" alt="배너">
			</div>
			<div class="d-flex">
				<div class="box-side col-4 d-flex justify-content-center align-items-center">
					<div class="text-white">
						<h1>실시간</h1>
						<h1>예약하기</h1>
					</div>	
				</div>
				<div class="box col-4 d-flex justify-content-center align-items-center">
					<div>
						<h4 class="text-white">예약확인</h4>
						<div class="d-flex align-items-center justify-content-end mb-2">
							<label for="name" class="text-white mr-3">이름:</label>
							<input type="text" class="form-control col-8" id="name">
						</div>
						<div class="d-flex align-items-center justify-content-end">
							<label for="phoneNumber" class="text-white mr-3">전화번호:</label>
							<input type="text" class="form-control col-8" id="phoneNumber">
						</div>
						<div class="text-right mt-2">
							<button type="button" id="checkBookingBtn" class="btn btn-success">조회 하기</button>
						</div>
					</div>
				</div>
				<div class="box-side col-4 d-flex justify-content-center align-items-center">
					<div class="text-white">
						<h4>예약문의:</h4>
						<h3>010-</h3>
						<h3>0000-1111</h3>
					</div>
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
	
	<script>
		$(document).ready(function(){
			
			$('#checkBookingBtn').on('click',function(){
				let name = $('#name').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				//validation
				if (name == ''){
					alert("이름을 입력하세요");
					return;
				}
				if (phoneNumber == ''){
					alert("전화번호를 입력하세요");
					return;
				}
				
				$.ajax({
					//request
						type: "post"
						, url: "/logPension/check_reservation"
						, data: {"name":name, "phoneNumber":phoneNumber}
					//response
					, success:function(data){
						if (data.code == 1){
							// 성공
							let date = new Date(data.result.date)
							alert("이름: " + data.result.name  +
							//"\n날짜: " + date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate() +
							"\n날짜: " + data.result.date.slice(0,10) +
							"\n일수: " + data.result.day +
							"\n인원: " + data.result.headcount +
							"\n상태: " + data.result.state);
						} else{
							// 실패
							alert(data.errorMessage);
						}
					}
					, error: function(request, status, error){
						alert("조회하는데 실패하였습니다. 관리자에게 문의하세요.")
					}
				});
			});
			
		});
	</script>

</body>
</html>















