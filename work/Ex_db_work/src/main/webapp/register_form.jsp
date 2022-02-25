<%@page import="dao.StudentDAO"%>
<%@page import="vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String name = request.getParameter("name");
 	int grade = Integer.parseInt(request.getParameter("grade"));
 	int height =Integer.parseInt( request.getParameter("height"));
 	int wight = Integer.parseInt(request.getParameter("wight"));
 	int deptno1 = Integer.parseInt(request.getParameter("deptno1"));
 	
 	StudentVo vo  =new StudentVo();
 	vo.setName(name);
 	vo.setGrade(grade);
 	vo.setHeight(height);
 	vo.setWight(wight);
 	vo.setDeptno1(deptno1);
 	
 	int res = StudentDAO.getInstance().insert(vo);
 	response.sendRedirect("student.jsp");
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>