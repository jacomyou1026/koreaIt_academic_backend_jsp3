<%@page import="vo.SawonVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SawonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SawonDAO sa = SawonDAO.getInstance();
	List<SawonVO> list = sa.selectList();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>급여</th>
		</tr>
		<%for(int i=0;i<list.size();i++){ %>
		<tr>
			<td><%=list.get(i).getSabun() %></td>
			<td><%=list.get(i).getSaname()%></td>
			<td><%=list.get(i).getSajob() %></td>
			<td><%=list.get(i).getSapay() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>