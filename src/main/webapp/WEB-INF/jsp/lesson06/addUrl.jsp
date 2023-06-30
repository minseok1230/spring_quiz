<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<label for="name">제목</label>
		<input type="text" class="form-control" id="name">
			<label for="name">주소</label>
		<div class="d-flex justify-content-between">
			<input type="text" class="form-control col-11" id="url">
			<button type="button" id="checkBtn" class="btn btn-info col-1">중복확인</button>
			
		</div>
		<small id="duplicationText" class="text-danger d-none">중복된 url입니다.</small>
		<small id="availableText" class="text-success d-none">저장 가능한 url입니다.</small>
		<input type="button" id="insertUrl" class="w-100 btn btn-success mt-3" value="추가">
	</div>
	
	<script>
		$(document).ready(function(){
			$("#insertUrl").on('click', function(){
				
				//validation
				let name = $('#name').val().trim();
				if (name == '') {
					alert("제목을 입력하세요");
					return;
				}
				
				let url = $('#url').val().trim();
				if (url == '') {
					alert("주소를 입력하세요");
					return;
				}
				
				// 주소형식이 잘못되었을 때 참
				// http 그리고 https
				if (url.startsWith('https://') == false && url.startsWith('http://') == false){
					alert("주소형식이 잘못되었습니다.");
					return;
				}
				
				// 문제2) 중복확인 체크 
				if ($('#availableText').hasClass('d-none')) { // 잘못된 경우 availableText d-none인 경우  
					alert("중복된 url입니다. 다시 확인해주세요.")
					return;
				}
				
				// AJAX
				$.ajax({
					//request
					type:"post"
					, url:"/lesson06/quiz01/add_url"
					, data: {"name":name, "url":url} // 파라미터로 넘길 데이터
				
					//response
					, success:function(data){ // String, JSON => 자바스크립트의 객체 변환
						/* alert(data.code);
						alert(data.result); */
						if (data.result == "성공"){
							location.href = "/lesson06/quiz01/after_add_url_view";
						}
					}
					, error:function(request, status, error){
						alert("즐겨찾기 추가하는데 실패했습니다.");
					}
				});
			});
			
			// 2-1) 중복확인 버튼
			$('#checkBtn').on('click', function(){
				
				let url = $('#url').val().trim();
				
				// validation
				// url 빈칸 확인
				if (!url){
					alert("검사할 url을 입력해주세요.");
					return;
				} 
				
				// AJAX 통신 => DB URL 존재 여부 
				$.ajax({
					
					//request
					type:"post"
					, url:"/lesson06/quiz01/is_duplication"
					, data: {"url":url} // 파라미터로 넘길 데이터
				
					//response
					,success:function(data){
							// {"code":1, "isDuplication": true}
						if (data.isDuplication) { // 중복
							$('#duplicationText').removeClass('d-none')
							$('availableText').addClass('d-none')
						} else{ // 사용 가능(중복 아님)
							$('#availableText').removeClass('d-none')
							$('#duplicationText').addClass('d-none')
						}
					}
					, error:function(request, status, error){
						alert("중복 확인에 실패했습니다.");
					}
				});
			});
		});
	</script>

</body>
</html>