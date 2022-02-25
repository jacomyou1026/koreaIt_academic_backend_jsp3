<%@page import="dao.StudentDAO"%>
<%@page import="vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
int studno= Integer.parseInt(request.getParameter("studno"));
String name = request.getParameter("name");
int grade= Integer.parseInt(request.getParameter("grade"));
int height= Integer.parseInt(request.getParameter("height"));
int weight= Integer.parseInt(request.getParameter("weight"));
int deptno1= Integer.parseInt(request.getParameter("deptno1"));

StudentVo vo = new StudentVo();
vo.setDeptno1(deptno1);
vo.setGrade(grade);
vo.setHeight(height);
vo.setName(name);
vo.setStudno(studno);
vo.setWight(weight);

int sd =StudentDAO.getInstance().update(vo);
if(sd>0){
	response.sendRedirect("student.jsp");
}

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