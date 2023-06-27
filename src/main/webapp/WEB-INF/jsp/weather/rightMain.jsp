<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<c:forEach items="${weatherHistory}" var="history">
					<tr>
						<td><fmt:formatDate value="${history.date}"
								pattern="yyyy년 M월 dd일" /></td>
						<td><c:choose>
								<c:when test="${history.weather == '비'}">
									<img src="/image/weather/rainy.jpg" alt="비">
								</c:when>
								<c:when test="${history.weather == '구름조금'}">
									<img src="/image/weather/partlyCloudy.jpg" alt="구름조금">
								</c:when>
								<c:when test="${history.weather == '흐림'}">
									<img src="/image/weather/cloudy.jpg" alt="흐림">
								</c:when>
								<c:when test="${history.weather == '맑음'}">
									<img src="/image/weather/sunny.jpg" alt="맑음">
								</c:when>
							</c:choose></td>
						<td>${history.temperatures}°C</td>
						<td>${history.precipitation}mm</td>
						<td>${history.microDust}</td>
						<td>${history.windSpeed}km/h</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>