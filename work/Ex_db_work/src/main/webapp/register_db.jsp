<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function send(f){
	var name = f.name.value.trim();
	var grade = f.grade.value.trim();
	var height= f.height.value.trim();
	var wight= f.wight.value.trim();
	//유효성 검사
	if(name == ''){
		alert('이름을 입력하세요');
		return;
	}
	
	//정수를 판단하는 정규식
	var patt  =/^[0-9]+$/;
	if(!patt.test(grade)|| grade <1 || grade >4){
		alert("학년(1~4) 정수 입력");
		return;
	}
	
	if(!patt.test(height)){
		alert("키 숫자 입력");
		return;
	}
	
	if(!patt.test(wight)){
		alert("몸무게 숫자 입력");
		return;
	}
	
	if(height==''){
		alert('키를 입력하세요');
		return;
	}
	if(wight==''){
		alert('몸무게를 입력하세요');
		return;
	}
	if(grade==''){
		alert('학년를 입력하세요');
		return;
	}
	//name속성을 파라미터로 넘긴다.
		f.submit(); //name,kor,eng,mat를 가지고
					//register_from.jsp로 넘어간다.
	
	}
</script>
<body>
	<form action="register_form.jsp">
		<table border="1">
			<caption>:::학생 추가하기:::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>학년</th>
				<td><input name="grade"></td>
			</tr>
			<tr>
				<th>키</th>
				<td><input name="height"></td>
			</tr>
			<tr>
				<th>몸무게</th>
				<td><input name="wight"></td>
			</tr>
			<tr>
				<th>반</th>
				<td><input name="deptno1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="등록"
					onclick="send(this.form);">
					 <input type="button" value="취소"
					onclick="location.href ='student.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>