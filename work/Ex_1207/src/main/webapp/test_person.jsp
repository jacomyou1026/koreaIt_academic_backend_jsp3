<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
   PersonVO p1 = new PersonVO();
  	p1.setName("일길동");
  	p1.setAge(20);
  	p1.setTel("010-111-1111");
  	
  	PersonVO p2 = new PersonVO();
  	p2.setName("이길동");
  	p2.setAge(30);
   	p2.setTel("010-222-2222");
   	
   	//p1,p2등 PersonVO객체를 저장하기 위한 ArrayList생성
   	ArrayList<PersonVO> pArr =new  ArrayList();
   	pArr.add(p1);
   	pArr.add(p2);
   	
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 style = "border: 10px auto">
	<caption>개인정보 목록</caption>
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
		</tr>
			<%for(int i=0;i<pArr.size();i++){ %>
		<tr>
			<td><%=pArr.get(i).getName() %></td>
			<td><%=pArr.get(i).getAge() %></td>
			<td><%=pArr.get(i).getTel() %></td>
		</tr>
			<%} %>
	</table>

</body>
</html>