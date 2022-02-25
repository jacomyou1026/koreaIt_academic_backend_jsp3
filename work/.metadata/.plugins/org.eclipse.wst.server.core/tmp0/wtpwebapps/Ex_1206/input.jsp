<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function v(f){
		f.submit();
	}
</script>
</head>
<body>
	<form action="df.jsp">
		<input name ="name">
		<input name ="sub">
		<input type = "button" onclick="v(this.form)">
	</form>
</body>
</html>