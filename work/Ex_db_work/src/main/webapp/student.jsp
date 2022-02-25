<%@page import="java.util.List"%>
<%@page import="vo.StudentVo"%>
<%@page import="dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%StudentDAO sd = StudentDAO.getInstance(); %>
<%List<StudentVo> sv = sd.selectList(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(name,no){
		if(confirm(name+" 학생을 정말 삭제하겠습니까?")==false){
			return;
		}else{
			location.href ="st_del.jsp?no="+no;
		}
	}
	function update(f){
		f.submit();
	}
	
</script>
</head>
<body>
	<table border=1>
		<caption>학생정보</caption>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>학년</th>
			<th>키</th>
			<th>몸무게</th>
			<th>부서</th>
			<th>비고</th>
		</tr>
		<%for(int i=0;i<sv.size();i++){
			StudentVo st = sv.get(i); %>
		<tr>
			<td><%=st.getStudno() %></td>
			<td><%=st.getName() %></td>
			<td><%=st.getGrade() %></td>
			<td><%=st.getHeight() %></td>
			<td><%=st.getWight() %></td>
			<td><%=st.getDeptno1() %></td>
			<td><input type="button" value="삭제"
				onclick="del('<%=st.getName()%>',<%=st.getStudno()%>);">

				<form action="update_result.jsp">
					<input type="button" value="수정" onclick="update(this.form)">
					<input type="hidden" value="<%=st.getStudno()%>" name="studno">
					<input type="hidden" value="<%=st.getName() %>" name="name">
					<input type="hidden" value="<%=st.getGrade() %>" name=grade>
					<input type="hidden" value="<%=st.getHeight() %>" name="height">
					<input type="hidden" value="<%=st.getWight() %>" name="wight">
					<input type="hidden" value="<%=st.getDeptno1() %>" name="deptno1">

				</form></td>
		</tr>
		<%}%>
		<tr align="center">
			<td align="center" colspan="7"><input type="button"
				value="학생 정보 추가" onclick="location.href ='register_db.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>