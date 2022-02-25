<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ins(f){
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
		
		f.action = "insert.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<table border ="1">
		<caption>고객 추가 </caption>
		<tr>
			<th>고객번호</th>
			<td><input name ="gobun"></td>
		</tr>	
		<tr>
			<th>고객이름</th>
			<td><input name ="goname"></td>
		</tr>	
		<tr>
			<th>고객주소</th>
			<td><input name ="goaddr"></td>
		</tr>	
		<tr>
			<th>고객주민번호</th>
			<td><input name ="gojumin"></td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<input type ="button" value ="추가" onclick="ins(this.form);">
				<input type ="button" value ="취소" onclick="location.href ='list.do'">
			</td>
		</tr>
	</table>
</body>
</html>