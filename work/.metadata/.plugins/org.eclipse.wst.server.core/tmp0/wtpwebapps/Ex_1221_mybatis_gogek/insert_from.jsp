<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		//유효성 검사
		f.action ="insert.do";
		f.submit();
	}
</script>
</head>
<!-- private int gobun;
	private String goname;
	private String goaddr;
	private String gojumin;
	private int godam;
	 -->
<body>
<form action="">
	<table border ="1" align="center"> 
		<caption>고객 추가 </caption>
		<tr>
			<td>고객번호</td>
			<td><input name ="gobun"></td>
		</tr>
		<tr>
			<td>고객이름</td>
			<td><input name ="goname"></td>
		</tr>
		<tr>
			<td>고객주소</td>
			<td><input name ="goaddr"></td>
		</tr>
		<tr>
			<td>고객주민번호</td>
			<td><input name ="gojumin"></td>
		</tr>
		<tr>
			<td>담당자번호</td>
			<td><input name ="godam"></td>
		</tr>
		<tr colspan="2" align="center">
			<td colspan="2">
				<input type ="button" onclick="send(this.form);" value="추가">
				<input type ="button" onclick="location.href='gogek_list.do'" value="취소">
			</td>
		</tr>
	</table>
</form>
	
</body>
</html>