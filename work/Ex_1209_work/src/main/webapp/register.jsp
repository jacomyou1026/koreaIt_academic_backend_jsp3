<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
	var name = f.name.value.trim();
	var kor = f.kor.value.trim();
	var eng = f.eng.value.trim();
	var mat = f.mat.value.trim();
	
	//유효성 검사
	if(name == ''){
		alert('이름을 입력하세요');
		return;
	}
	
	//정수를 판단하는 정규식
	var patt  =/^[0-9]+$/;
	if(!patt.test(kor) || kor<0||kor>100 ){
		alert("성적은 0~100사이의 정수입니다.")
		return;
	}
	
	if(!patt.test(eng) || eng<0||eng>100 ){
		alert("성적은 0~100사이의 정수입니다.")
		return;
	}
	
	if(!patt.test(mat) || mat<0||mat>100 ){
		alert("성적은 0~100사이의 정수입니다.")
		return;
	}
	
	if(kor==''){
		alert('국어점수를 입력하세요');
		return;
	}
	if(eng==''){
		alert('영어점수를 입력하세요');
		return;
	}
	if(mat==''){
		alert('수학점수를 입력하세요');
		return;
	}
	//name속성을 파라미터로 넘긴다.
		f.submit(); //name,kor,eng,mat를 가지고
					//register_from.jsp로 넘어간다.
	
	}
</script>
</head>
<body>
	<form action="register_from.jsp">
		<table border="1">
			<caption>:::학생 추가하기:::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input name="kor"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input name="eng"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input name="mat"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="등록"
					onclick="send(this.form);"> <input type="button" value="취소"
					onclick="location.href ='db_sungtb.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>