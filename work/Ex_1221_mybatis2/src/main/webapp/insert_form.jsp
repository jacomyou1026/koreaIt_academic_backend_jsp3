<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		//유효성 검사
		f.submit();
	}
</script>
</head>
<body>
	<form action="insert.do">
		사번 : <input name ="sabun"><br>
		이름 : <input name ="saname"><br>
		성별 : <input name ="sagen"><br>
		부서번호 : <input name ="deptno"><br>
		직책 : <input name ="sajob"><br>
		입사일: <input name ="sahire" placeholder="yyyy-mm-dd"><br>
		상사번호 : <input name ="samgr"><br>
		급여: <input name ="sapay"><br>
		
		<input type ="button" value="사원추가" onclick="send(this.form);">
		<input type ="button" value="취소" onclick="location.href='sawon_list'">
	</form>
</body>
</html>