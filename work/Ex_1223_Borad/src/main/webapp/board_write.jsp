<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		function send_check(){
			
			//var f = document.getElementById("f");
			var f = document.ff;//ff라는 name을 가진 form태그를 검색
			
			//유효성체크
			
			//insert.do?subject=제목&name=작성자명&content=내용&pwd=1111
			f.submit();
			
			
		}
	</script>

</head>
<body>
	<form name="ff" id="f" method="post" action="insert.do">
		<table width="700" border="1" align="center">
			<caption>:::새 글 작성:::</caption>
			
			<tr>
				<td width="120">제목</td>
				<td><input name="subject" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td width="120">작성자</td>
				<td><input name="name" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td width="120">내용</td>
				<td><textarea name="content" rows="10" cols="80"></textarea></td>
			</tr>
			
			<tr>
				<td width="120">비밀번호</td>
				<td><input name="pwd" type="password" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<img src="img/btn_reg.gif" onclick="send_check();">
					
					<img src="img/btn_back.gif" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



