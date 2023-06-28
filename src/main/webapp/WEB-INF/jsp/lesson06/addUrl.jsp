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
		<input type="text" class="form-control" id="url">
		<input type="button" id="insertUrl" class="w-100 btn btn-success mt-3" value="추가">
	</div>
	
	<script>
		$(document).ready(function(){
			$("#insertUrl").on('click', function(){
				
				//validation
				let name = $('#name').val().trim();
				if (name == '') {
					alert("주소명을 입력하세요");
					return;
				}
				
				let url = $('#url').val().trim();
				if (url == '') {
					alert("주소를 입력하세요");
					return;
				}
				
				// AJAX
				$.ajax({
					//request
					type:"post"
					, url:"/lesson06/quiz01/add_url"
					, data: {"name":name, "url":url}
				
					//response
					, success:function(data){
						if (data == "성공"){
							location.href = "/lesson06/quiz01/after_add_url_view"
						} else{
							alert("url등록 실패")
						}
					}
					
					, error:function(request, status, error){
						alert(request);
						alert(status);
						alert(error);
					}
					
				});
				
			});
		});
	</script>

</body>
</html>