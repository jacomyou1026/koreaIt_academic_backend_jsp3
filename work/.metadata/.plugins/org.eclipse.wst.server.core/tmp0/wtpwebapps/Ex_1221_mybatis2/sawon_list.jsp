<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">	
	function find(){
		var deptno = document.getElementById("deptno").value;
		location.href ="sawon_list?deptno="+deptno;
	}
	function findName(){
		var search = document.getElementById("search").value.trim();
		
		if(search == ""){
			search ="all";
		}
		
		location.href ="sawon_list?search="+search;
		
		
	}
</script>
</head>
<body>
	<div align="center">
		<input  type ="button" value="사원추가" onclick="location.href='insert_form.jsp'">
	</div>
	<div align ="center">
		부서 : 
		<select id ="deptno">
			<option value="0">부서를 선택하세요</option>
			<option value="10">총무부</option>
			<option value="20">영업부</option>
			<option value="30">전산실</option>
			<option value="40">관리부</option>
			<option value="50">경리부</option>
		</select>
		<input type ="button" value ="검색" onclick="find();">
	</div>
	<div align="center">
		이름 : <input id="search" placeholder="이름으로 검색하세요">
		<input type ="button" value ="검색"  onclick="findName();">
	</div>
	<table border="1" align= "center">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>성별</th>
			<th>부서번호</th>
			<th>직업</th>
			<th>입사일</th>
			<th>상사번호</th>
			<th>연봉</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
			<td>${vo.sabun }</td>
			<td>${vo.saname}</td>
			<td>${vo.sagen}</td>
			<td>${vo.deptno }</td>
			<td>${vo.sajob}</td>
			<td>${vo.sahire }</td>
			<td>${vo.samgr}</td>
			<td>${vo.sapay}</td>
			
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>