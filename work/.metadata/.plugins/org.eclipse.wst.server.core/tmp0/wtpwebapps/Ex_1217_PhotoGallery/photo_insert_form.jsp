<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		var title = f.title.value;
		var pwd= f.pwd.value;
		var photo= f.photo.value;
		
		if(title ==''){
			alert("제목을 입력하세요");
			return;
		}
		if(pwd==''){
			alert("비밀번호르 입력하세요 입력하세요");
			return;
		}
		if(photo ==''){
			alert("파일을 선택하세요");
			return;
		}
		
		f.action = "insert.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data">
		<table border="1" align ="center">
			<caption>사진 등록하기</caption>
			<tr>
				<th>제목</th>
				<td>
					<input name ="title">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name ="pwd">
				</td>
			</tr>
			<tr>
				<th>업로드 할 사진</th>
				<td>
					<input type ="file" name ="photo">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type ="button" value ="등록" onclick="send(this.form);">
					<input type ="button" value ="취소" onclick="location.href ='list.do'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>