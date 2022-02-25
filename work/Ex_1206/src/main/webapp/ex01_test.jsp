<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jsp(java server page) : 내부적으로 연산능력을 가지는 html -->
<!-- jsp >>>> servlet >>> UI -->
<!--  스크립트릿(script let) : jsp에서 자바코드를 사용하고 싶을 때 지정하는 영역-->
<%
	//스크립트 릿의 영역
	String name ="홍길동";
	int age = 40;
	char gender = '남';
	//request(요청처리객체) : 사용자의 요청을 받는 객체
	//reponse(응답처리객체) : 요청을 받아 처리 후 ui로 갱신해주는 객체
	String ip = request.getRemoteAddr();//접속자의 ip주소 가져오기
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	&lt; %@내용% &gt; :	JSP헤더 - 페이지 실행 시, 인코딩 타입, import 문장 등의 
	설정을 위해 반드시 필요한 영역<br>
	
	&lt; %자바코드 %&gt; : 스크립트 릿 - jsp에서 자바코드를 사용하고자 할 떄 지정하는 영역<br><br> 
	
	&lt; %=변수명%&gt; : 스크립트 릿에서 생성한 변수의 값을 출력하는 코드<br><br> 
	
	--정보---<br>
	이름 : <%=name %><br>
	나이 : <%=age %><br>
	성별 : <%=gender %><br>
	ip  : <%=ip %> 
	
</body>
</html>