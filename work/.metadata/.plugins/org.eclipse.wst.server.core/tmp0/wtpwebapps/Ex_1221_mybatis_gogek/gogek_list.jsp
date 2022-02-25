<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function find(){
		var deptno = document.getElementById("deptno").value;
		location.href="gogek_list.do?deptno="+deptno;
	}
	
	function serach(){
		var name = document.getElementById("name").value.trim();
		if(name==""){
			name = "all";
		}
			location.href="gogek_list.do?name="+name;
		
		
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<input type="button" value="고객추가" onclick="location.href='insert_from.jsp'">
	</div>
	<div align="center">
	<div align="center">
		고객이름:
		<input id="name">
		<input type="button" value="찾기" onclick="serach();">
	</div>
	<div align="center">
	담당번호 :
		<select id="deptno">
			<option value="0">담당번호를 입력하세요</option>
			<option value="4">4</option>
			<option value="10">10</option>
			<option value="12">12</option>
			<option value="15">15</option>
		</select>
		<input type="button" value="검색" onclick="find();">
	</div>
	<table border="1" align="center">
	<caption>고객회원리스트</caption>
		<tr>
			<th>고객번호</th>
			<th>이름</th>
			<th>고객주소</th>
			<th>주민번호</th>
			<th>담당자 번호</th>
			
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.gobun }</td>
				<td>${vo.goname}</td>
				<td>${vo.goaddr}</td>
				<td>${vo.gojumin}</td>
				<td>${vo.godam}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>