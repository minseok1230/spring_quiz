<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약자 목록</title>
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
			<div class="d-flex justify-content-center">
				<h2 class="mt-4">예약 목록 보기</h2>
			</div>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList}" var="booking">
						<tr>
							<td>${booking.name}</td>
							<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/></td>
							<td>${booking.day}</td>
							<td>${booking.headcount}</td>
							<td>${booking.phoneNumber}</td>
							<c:if test="${booking.state == '대기중'}">
								<td class="text-info">${booking.state}</td>
							</c:if>
							<c:if test="${booking.state == '확정'}">
								<td class="text-success">${booking.state}</td>
							</c:if>
							<td><button type="button" class="deleteBtn btn btn-danger" data-booking-id="${booking.id}">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
			$('.deleteBtn').on('click',function(){

				let id = $(this).data('booking-id');
				//alert(id);
				
				$.ajax({
					//request
					type: "delete"
					, url : "/logPension/delete_reservation"
					, data: {"bookingId": id}
				
					//response
					, success: function(data) {
						if (data.code == 1){
							alert("삭제 되었습니다.");
							location.reload(true);
						} else {
							alert(data.errorMessage);
						}
					}
					, error: function(request, status, error){
						alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.")
					}
				})
			});
		});
	
	</script>
	

</body>
</html>





















