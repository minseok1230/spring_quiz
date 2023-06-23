<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 득표율</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>1. 후보자 득표율</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>기호</th>
					<th>득표수</th>
					<th>득표율</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${candidates}" var="candidate" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><fmt:formatNumber value="${candidate}"/></td>
						<td><fmt:formatNumber type="percent" value="${candidate / totalCount}"/></td>
						<%-- 계산은 controller에서 하는 것이 좋다. 역할분산. --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<h1>2. 카드 명세서</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>사용처</th>
					<th>가격</th>
					<th>사용 날짜</th>
					<th>할부</th>
				</tr>
			</thead>
			<thead>
				<c:forEach items="${cardBills}" var="cardBill">
					<fmt:parseDate value="${cardBill.date}" pattern="yyyy-MM-dd" var="changeDate"/>
					<tr>
						<td>${cardBill.store}</td>
						<td><fmt:formatNumber type="currency" value="${cardBill.pay}"/></td>
						<td><fmt:formatDate value="${changeDate}" pattern="yyyy년 M월 d일"/></td>
						<td>${cardBill.installment}</td>
					</tr>
				</c:forEach>
			</thead>
		
		</table>
	</div>

</body>
</html>

















