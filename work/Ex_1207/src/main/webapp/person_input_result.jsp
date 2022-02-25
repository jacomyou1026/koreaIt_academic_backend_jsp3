<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String name = request.getParameter("my_name");
 	int age= Integer.parseInt(request.getParameter("my_age"));
 	String tel= request.getParameter("my_tel");
 
 %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<caption>정보</caption>
	 이름 : <%=name %><br>
	 나이 : <%=age%><br>
	 전화번호 : <%=tel %><br>
</body>
</html>