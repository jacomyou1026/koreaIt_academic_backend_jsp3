<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* function send(f){
		var name= f.my_name.value;
		var age = f.my_age.value;
		var tel = f.my_tel.value;
		/* 
		if(name ==''){
			alert("이름을 입력하세요");
			return
		}  */
		/* if(age==''){
			alert("이름을 입력하세요");
			return
		}
		if(tel==''){
			alert("이름을 입력하세요");
			return
		} */
		
		f.submit(); //지정된 action으로 파라미터를 가지고 페이지 전환
	} */
</script>
</head>
<body>
	<form action="person_input_result.jsp">
		이름 : <input name="my_name" required="required"><br> 
		나이 : <input type="number" name="my_age" required><br>
		전화 : <input name="my_tel" required="required"><br> 
		<input type="submit" value ="확인" >
	</form>

</body>
</html>