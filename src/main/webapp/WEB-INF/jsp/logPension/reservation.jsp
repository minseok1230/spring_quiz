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

<%--datepicker --%>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
			<div class="my-4 d-flex justify-content-center">
				<h2 class="font-weight-bold">예약 하기</h2>
			</div>
			<div class="form-group d-flex justify-content-center w-100">
				<div class="w-50">
					<span>이름</span>
					<input type="text" id="name" class="form-control my-2">
					<span>예약날짜</span>
					<input type="text" id="date"  class="form-control my-2">
					<span>숙박일수</span>
					<input type="text" id="day" class="form-control my-2">
					<span>숙박인원</span>
					<input type="text" id="headcount" class="form-control my-2">
					<span>전화번호</span>
					<input type="text" id="phoneNumber" class="form-control my-2">
					<button type="button" id="addBookingBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
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
		$(document).ready(function() {
			
			// 날짜 선택 데이트 피커
			$('#date').datepicker({
				changeMonth : true, // 월 셀렉트 박스 
				changeYear : true, // 년 셀렉트 박스 
				dateFormat : "yy-mm-dd", // 표시 포멧 
				minDate: 0
			});
			
			$('#addBookingBtn').on('click', function(){
				let name = $('#name').val().trim();
				let date = $('#date').val().trim();
				let day = $('#day').val();
				let headcount = $('#headcount').val();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				//validation
				if (name == ''){
					alert("이름을 입력하세요");
					return;
				}
				if (date.length < 1){
					alert("날짜를 입력하세요");
					return;
				}
				if (!day){
					alert("숙박일수를 입력하세요");
					return;
				}
				if (isNaN(day)){ // 숫자가 입력받을때 참
					alert("숙박일수는 숫자만 입력 가능합니다.");
					return;
				}
				if (headcount == ''){
					alert("인원수를 입력하세요");
					return;
				}
				if (isNaN(headcount)){ // 숫자가 입력받을때 참
					alert("숙박인원은 숫자만 입력 가능합니다.");
					return;
				}
				if (phoneNumber == ''){
					alert("전화번호를 입력하세요");
					return;
				}
				
				
				// AJAX 요청 - insert
				$.ajax({
					// request
					type: "post"
					, url : "/logPension/add_reservation"
					, data : {"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber }
					
					// response
					, success: function(data){
						if (data.code == 1){
							alert("예약되었습니다.");
							location.href = "/logPension/reservation_list_view"
						} else{
							alert(data.errorMessage);
						}
					}
					, error: function(request, status, error){
						alert("예약하는데 실패했습니다. 관리자에게 문의하세요")
					}
				});
			});
		});
	</script>

</body>
</html>



















