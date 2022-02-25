<%@page import="java.util.ArrayList"%>
<%@page import="vo.GogekVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<% 
	//JNDI검색을 위한 준비
	InitialContext ic = new InitialContext();
	
	//Resource(참조파일)
	Context ctx = (Context)ic.lookup("java:comp/env");
	
	//찾아낸 JNDI에서 Resource영역에 지정해둔 name속성값을 가져온다.
	DataSource dataSource = (DataSource) ctx.lookup("jdbc/oracle_test");
	
	//DB에 연결 시도하기
	Connection conn = dataSource.getConnection();
 	String sql = "select goname,goaddr,gojumin from gogek ";
 	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs= ps.executeQuery();
	ArrayList<GogekVo> al = new ArrayList();
	
	while(rs.next()){
		GogekVo gv  =new GogekVo();
		gv.setGoname(rs.getString("goname"));
		gv.setGoaddr(rs.getString("goaddr"));
		gv.setGojumin(rs.getString("gojumin"));
		al.add(gv);
	}
	rs.close();
	ps.close();
	conn.close();
 	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ="1">
	<caption style="font-weight :bold">목록</caption>
	<tr>
		<th>고객이름</th>
		<th>고객주소</th>
		<th>고객주민번호</th>
	</tr>
		<%for(int i=0;i<al.size();i++){
			 GogekVo gv= al.get(i);
		%>
	<tr>
		<td><%=gv.getGoname() %></td>
		<td><%=gv.getGoaddr() %></td>
		<td><%=gv.getGojumin() %></td>
	</tr>
		<%} %>
	
	
	</table>
</body>
</html>