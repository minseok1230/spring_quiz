<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link href="/css/weather/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="wrap">
		<div class="contents d-flex">
			<jsp:include page="nav.jsp" />
			<div class="rightMain">
				<h2 class="ml-5 mt-4 font-weight-bold">과거날씨</h2>
				<div class="d-flex justify-content-center align-items-center">
					<div class="tableBox">
						<table class="table text-center">
							<thead>
								<tr>
									<th>날짜</th>
									<th>날씨</th>
									<th>기온</th>
									<th>강수량</th>
									<th>미세먼지</th>
									<th>풍속</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${weatherHistory}" var="weather">
								<fmt:parseDate value="${weather.getDate()}" pattern="yyyy-MM-dd" var="strDate"/>
									<tr>
										<td>
											<fmt:formatDate value="${strDate}" pattern="yyyy년 M월 dd일"/>
										</td>
										<td>
											<c:choose>
												<c:when test="${weather.getWeather() == '비'}">
													<img src="/image/weather/rainy.jpg">
												</c:when>
												<c:when test="${weather.getWeather() == '구름조금'}">
													<img src="/image/weather/partlyCloudy.jpg">
												</c:when>
												<c:when test="${weather.getWeather() == '흐림'}">
													<img src="/image/weather/cloudy.jpg">
												</c:when>
												<c:when test="${weather.getWeather() == '맑음'}">
													<img src="/image/weather/sunny.jpg">
												</c:when>
											</c:choose>
										</td>
										<td>${weather.getTemperatures()}°C</td>
										<td>${weather.getPrecipitation()}mm</td>
										<td>${weather.getMicroDust()}</td>
										<td>${weather.getWindSpeed()}km/h</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>

</body>
</html>