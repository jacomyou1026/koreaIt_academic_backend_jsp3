<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--include속성을 통해 타 jsp를 불러서와서 호출 가능  -->
	<jsp:include page="check_login.jsp"/>
	
	${vo.name }님 접속을 환영합니다.<br>
	<input type ="button" value="로그아웃" onclick="location.href='logout.do'">
</body>
</html>