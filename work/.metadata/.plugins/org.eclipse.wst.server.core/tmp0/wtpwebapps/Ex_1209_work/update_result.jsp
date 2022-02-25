<%@page import="dao.SungtbDAO"%>
<%@page import="vo.SungtbVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");%>
<%int no = Integer.parseInt(request.getParameter("no"));  %>
<%String  name =  request.getParameter("name");%>
<%int  kor =  Integer.parseInt(request.getParameter("kor"));%>
<%int  eng =  Integer.parseInt(request.getParameter("eng"));%>
<%int  mat=  Integer.parseInt(request.getParameter("mat"));%>
<%
	SungtbVo vo = new SungtbVo();
	vo.setNo(no);
	vo.setName(name);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	

	int res = SungtbDAO.getInstance().update(vo);
	//location.href = "db_sungtb.jsp";
	if(res>0){
		response.sendRedirect("db_sungtb.jsp");//db_sungtb.jsp로 화면 전환
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