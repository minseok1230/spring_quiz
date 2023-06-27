<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 추가</title>


<%-- jquery --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<%--부트스트랩 --%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<%--datepicker --%>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- 내가만든 스타일시트 -->
<link href="/css/weather/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
			<div class="contents d-flex">
				<jsp:include page="nav.jsp" />
				<%-- 날씨 추가 --%>
				<div class="rightMain col-8 mt-3 ml-5">
					<h2 class="ml-5 mt-4 font-weight-bold mb-5">날씨 입력</h2>
					
					<form method="post" action="/weather/weather_adding">
						<%-- 날짜 날씨 미세먼지 --%>
						<div class="d-flex justify-content-between">
							<div class="d-flex">
								<div class="input-label">날짜</div>
								<input type="text" class="form-control" id="date" name="date">
							</div>
							<div class="d-flex">
								<div class="input-label">날씨</div>
								<select class="form-control" id="weather" name="weather">
									<option value="맑음">맑음</option>
									<option value="구름조금">구름조금</option>
									<option value="흐림">흐림</option>
									<option value="비">비</option>
								</select>
							</div>
							<div class="d-flex">
								<div class="input-label">미세먼지</div>
								<select class="form-control" id="microDust" name="microDust">
									<option value="좋음">좋음</option>
									<option value="보통">보통</option>
									<option value="나쁨">나쁨</option>
									<option value="최악">최악</option>
								</select>
							</div>
						</div>
						
						<%-- 기온 강수량 풍속 --%>
						<div class="d-flex justify-content-center mt-5">
							<div class="d-flex">
								<div class="input-label">기온</div>
								<div class="input-group">
									<input type="text" class="form-control" name="temperatures">
									<div class="input-group-append">
										<span class="input-group-text">℃</span>
									</div>
								</div>	
							</div>
							<div class="d-flex">
								<div class="input-label">강수량</div>
								<div class="input-group">
									<input type="text" class="form-control" name="precipitation">
									<div class="input-group-append">
										<span class="input-group-text">mm</span>
									</div>
								</div>	
							</div>
							<div class="d-flex">
								<div class="input-label">풍속</div>
								<div class="input-group">
									<input type="text" class="form-control" name="windSpeed">
									<div class="input-group-append">
										<span class="input-group-text">km/h</span>
									</div>
								</div>	
							</div>
						</div>
						
						<div class="text-right mt-4 mb-5">
							<input type="submit" class="btn btn-success" value="저장">
						</div>
					</form>
					
				</div>
			</div>
			<footer>
				<jsp:include page="footer.jsp" />
			</footer>
		</div>
		
		<%-- 자바스크립트 --%>
		<script>
		$(document).ready(function() {
			
			$('#date').datepicker({
                showButtonPanel: true // 오늘 버튼 노출
                , changeYear: true
                , changeMonth: true
            });
			
            // 모든 데이터피커에 적용
            $.datepicker.setDefaults({
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] // 요일을 한글로 변경
                , dateFormat: 'yy-mm-dd'
            });

            // 오늘 날짜로 이동하는 함수
            $.datepicker._gotoToday = function(id) {
                $(id).datepicker('setDate', new Date()).datepicker('hide').blur();
            };
        });
		</script>
</body>
</html>