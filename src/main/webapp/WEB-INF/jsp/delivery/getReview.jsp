<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의민족 리뷰</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link href="/css/delivery/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<header class="bg-info d-flex align-items-center">
			<h1 class="text-white ml-4"><b>배탈의 민족</b></h1>
		</header>
		<div class="contents">
			<div class="display-3 mb-3">${name} - 리뷰</div>
			<c:forEach items="${storeList}" var="store">
				<div class="storeBox d-flex align-items-center pl-4" style="height: 150px; width: 100%; border:1px solid #09A97E; ">
					<div>
					<!-- test06/reviews?storeId=3&storeName=BHC -->
						<h2 class="font-weight-bold"><a href="/delivery/store_review_view?id=${store.id}&name=${store.name}">${store.name}</a></h2>
						<h4>전화번호: ${store.phoneNumber}</h4>
						<h4>주소: ${store.address}</h4>
					</div>
				</div><br>
			</c:forEach>
		</div>
		<footer class="bg-danger">
			<hr>
			<h3>(주)우와한 형제</h3>
			<small class="text-secondary">고객센터 : 1500-1500</small>
		</footer>
	</div>

</body>
</html>