<%@page import="java.util.List"%>
<%@page import="vo.DeptVO"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DeptDAO dao = DeptDAO.getInstance();
	List<DeptVO> dept_list = dao.selectList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
	<caption>부서목록</caption>
		<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>부서위치</th>
		</tr>
		<%for(int i =0;i<dept_list.size();i++){ %>
		<tr>
			<td><%=dept_list.get(i).getDeptno() %></td>
			<td><%=dept_list.get(i).getDname() %></td>
			<td><%=dept_list.get(i).getLoc() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>