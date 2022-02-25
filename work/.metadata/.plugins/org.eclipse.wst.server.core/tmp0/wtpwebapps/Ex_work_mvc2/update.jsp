<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		var goname = f.goname.value.trim();
		var goaddr= f.goaddr.value.trim();
		var gojumin = f.gojumin.value.trim();
		
		if(goname ==''){
			alert('이름을 입력해주세요');
			return;
		}
		
		if(goaddr ==''){
			alert('주소를 입력해주세요');
			return;
		}
		
		if(gojumin ==''){
			alert('주민번호를 입력해주세요');
			return;
		}
		
		f.action = "update.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<form action="">
		<input type="hidden" value="${gobun }" name="gobun">
		<table border =	1>
			<caption>고객 수정 페이지</caption>
			<tr>
				<th>고객이름</th>
				<td><input value ="${goname }" name ="goname"> </td>
			</tr>
			<tr>
				<th>고객주소</th>
				<td><input value ="${goaddr}" name ="goaddr"> </td>
			</tr>
			<tr>
				<th>고객주민번호</th>
				<td><input value ="${gojumin }" name ="gojumin"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type ="button" value="수정" onclick="send(this.form);">
					<input type ="button" value="취소" onclick="location.href ='list.do'">
				</td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>