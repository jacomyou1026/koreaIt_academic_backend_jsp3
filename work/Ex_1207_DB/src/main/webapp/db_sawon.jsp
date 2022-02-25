<%@page import="vo.SwonVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%
int no = Integer.parseInt(request.getParameter("deptno"));
System.out.println(no+"2dfdfdfddfdf");
System.out.println("-s--");
InitialContext ic = new InitialContext();

//Resource(참조파일)
Context ctx = (Context)ic.lookup("java:comp/env");

//찾아낸 JNDI에서 Resource영역에 지정해둔 name속성값을 가져온다.
DataSource dataSource = (DataSource) ctx.lookup("jdbc/oracle_test");

//DB에 연결 시도하기
Connection conn = dataSource.getConnection();

String sql = "select * from SAWON where deptno="+no;

PreparedStatement ps = conn.prepareStatement(sql);

ResultSet rs = ps.executeQuery();

ArrayList<SwonVo> al = new ArrayList();

while(rs.next()){
	SwonVo sw = new SwonVo();
	sw.setDeptno(rs.getInt("deptno")); //사원부서
	sw.setSabun(rs.getInt("sabun"));
	sw.setSajob(rs.getString("sajob"));
	sw.setSaname(rs.getString("saname"));
	al.add(sw);
	
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
	<table border = "1">
		<tr>
			<th>부서번호</th>
			<th>사원번호</th>
			<th>직책</th>
			<th>이름</th>
		</tr>
		<%for(int i =0;i<al.size();i++){
			SwonVo sw = al.get(i);%>
		<tr>
			<td><%=sw.getDeptno() %></td>
			<td><%=sw.getSabun() %></td>
			<td><%=sw.getSajob()%></td>
			<td><%=sw.getSaname() %></td>
		</tr>
		<%} %>	
	</table>
</body>
</html>