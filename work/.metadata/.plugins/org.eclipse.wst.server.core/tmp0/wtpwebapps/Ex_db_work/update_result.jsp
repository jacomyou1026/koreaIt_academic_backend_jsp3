<%@page import="org.apache.catalina.filters.SetCharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int studno= Integer.parseInt(request.getParameter("studno"));
	String name = request.getParameter("name");
	int grade= Integer.parseInt(request.getParameter("grade"));
	int height= Integer.parseInt(request.getParameter("height"));
	int weight= Integer.parseInt(request.getParameter("wight"));
	int deptno1= Integer.parseInt(request.getParameter("deptno1"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(f){
	var name = f.name.value.trim();
	var grade = f.grade.value.trim();
	var height = f.height.value.trim();
	var weight = f.weight.value.trim();
	var deptno1 = f.deptno1.value.trim();
	
	var patt=/^[0-9]+$/;
	if(!patt.test(grade)||grade<1||grade>4 ){
		alert('학년을 정수로 입력해주세요');
		return;
	}
	
	if(!patt.test(height)){
		alert('키를 정수로 입력해주세요');
		return;
	}
	if(!patt.test(weight)){
		alert('몸무게를 정수로 입력해주세요');
		return;
	}
	if(!patt.test(deptno1)){
		alert('반을 정수로 입력해주세요');
		return;
	}
	
	if(name == ''){
		alert('이름을 입력해주세요');
		return;
	}
	if(grade== ''){
		alert('학년을 입력해주세요');
		return;
	}
	if(height == ''){
		alert('키를 입력해주세요');
		return;
	}
	if(weight == ''){
		alert('몸무게를 입력해주세요');
		return;
	}
	if(deptno1== ''){
		alert('반을 입력해주세요');
		return;
	}
	
	f.submit();
	
}
</script>
</head>
<body>
<form action="update_real_result.jsp">
	<input type = "hidden" value = "<%=studno%>" name = "studno">
	<table border =1>
		<caption>:: 학생 정보 수정 ::</caption>
		<tr>
			<th>이름</th>
			<td>
				<input value ="<%=name%>" name ="name">
			</td>
		</tr>
		<tr>
			<th>학년</th>
			<td>
				<input value ="<%=grade%>" name ="grade">
			</td>
		</tr>
		<tr>
			<th>키</th>
			<td>
				<input value ="<%=height%>" name ="height">
			</td>
		</tr>
		<tr>
			<th>몸무게</th>
			<td>
				<input value ="<%=weight%>" name ="weight">
			</td>
		</tr>
		<tr>
			<th>반</th>
			<td>
				<input value ="<%=deptno1%>" name ="deptno1">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type ="button" value = "수정" 
			onclick="send(this.form);"> 
			<input type ="button" value = "취소" 
				onclick="location.href ='student.jsp'"> 
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>