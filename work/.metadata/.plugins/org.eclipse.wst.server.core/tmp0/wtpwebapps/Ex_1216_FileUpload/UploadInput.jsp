<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		var title = f.title.value.trim();
		var photo = f.photo.value;
		if(title ==''){
			alert('제목을 입력하세요');
			return;
		}
		
		if(photo ==''){
			alert('사진을 선택해주세요');
			return;
		}
		
		f.action = "upload.do";
		f.submit();
	}
</script>
</head>
<body>
	<!-- get : String 형태로 나감 -->
	<!-- 파일업로드시 고려사항 -->
	<!--  1)반드시 form태그 안에서 업로그 할 것-->
	<!--  2)form의 전송방식은 POST-->
	<!--  3)enctype = "multipart/form-data"-->
	<form method="post" enctype = "multipart/form-data">
		제목 : <input name = "title" ><br>
		첨부 : <input type ="file" name = "photo"><br>
		<input type ="button" value="업로드" onclick= "send(this.form);">
	</form>
</body>
</html>