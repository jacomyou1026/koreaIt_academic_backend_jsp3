<%@page import="vo.DeptVo"%>
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
	
	System.out.println("--연결성공--");
	
	//sql문장
	String sql = "select * from dept";
	
	//DB에 쿼리 요청
	PreparedStatement ps = conn.prepareStatement(sql);
	
	//쿼리문을 수행하여 결과를 받아온다.
	ResultSet rs = ps.executeQuery();
	
	//부서의 모든 목록을 저장할 Arraylist
	ArrayList<DeptVo> dt= new ArrayList();
	
	//DB의 모든 행을 순회하며 데이터를 가져온다.
	while(rs.next()){
		//현재 rs가 자리잡고 있는 해 위치의 실제 데이터들을 vo에 저장
		DeptVo vo =new DeptVo();
		vo.setDeptno(rs.getInt("deptno"));
		vo.setDname(rs.getString("dname"));
		vo.setLoc(rs.getString("LOC"));
		dt.add(vo);
	}
	
	//DB연결 및 접근에 사용하
	rs.close();
	ps.close();
	
	//DB사용 후 계속 머물러 있으면 11번째 사용자가 접속하지 못하므로
	//DB사용 후 빠져나가도록 연결을 해제
	conn.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(no){
		
		
		location.href = "db_sawon.jsp?deptno="+no;
		
 	}
	
</script>
</head>
<body>
	<table border = "1">
	<caption style="font-weight :bold">부서목록</caption>
		<tr>
			 <th>부서번호</th>
			 <th>부서이름</th>
			 <th>부서위치</th>
		</tr>
		<%
		for(int i=0;i<dt.size();i++){ 
				DeptVo vo = dt.get(i);
		%>
		
		<tr>
			<td><%=vo.getDeptno() %></td>
			<td>
			
				<a href="javascript:send('<%=vo.getDeptno() %>');">
					<%=vo.getDname()%>
				</a>
			</td>
			<td><%=vo.getLoc() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>