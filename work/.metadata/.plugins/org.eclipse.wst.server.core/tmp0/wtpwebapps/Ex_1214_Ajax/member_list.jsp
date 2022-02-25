<%@page import="dao.MemberDAO"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
  
<!-- JSTL( jsp standard tag library ) 
     : jsp영역에서 for, if문등을 사용할 수 있도록 해 주는 문법 -->  
 
<!-- forEach, if등 제어문을 사용하기 위한 라이브러리 등록 --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- AJax를 사용을 위해 httpRequest.js파일 가져온다.-->
<script src="js/httpRequest.js"></script>

<title>Insert title here</title>
	<script type="text/javascript">
	function del(f){
		if(!confirm("정말 삭제하갰습니까?")){
			return;
		}
		
		//삭제를 원하는 idx를 ajax를 통해 서블릿으로 전달
		
		var url ="del.do";
		var param = "idx="+f;
		sendRequest(url,param,delFun,"GET");
	}
	
	function delFun(){
		
		if( xhr.readyState == 4 && xhr.status == 200){
			
			//param = "[{'p':'yes'}]";
			var data1 = xhr.responseText;
			var json1 = eval(data1);
			
			if(json1[0].p=='yes'){
				alert("완전히 삭제되었습니다.");
			}else{
				alert("삭제되지 못하였습니다.");
			}
			
			location.href="list.do";
		}
	}
	</script>
</head>
<body>
	
	${ my_list.get(0).name }<br>
	${ my_list.get(0).id }
	
	<table border="1">
		<caption>:::회원목록:::</caption>
		
		<tr>
			<td colspan="7">
				<input type="button" value="회원가입" 
				       onclick="location.href='member_insert_form.jsp'"> 
			</td>
		</tr>
		
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th colspan="2">주소</th>
		</tr>
		
		<!-- forEach의 문법
		forEach var="변수,객체" items="포워딩받은 객체" -->
		<c:forEach var="vo" items="${ my_list }">
		<tr>
			<td>${ vo.idx }</td>
			<td>${ vo.name }</td>
			<td>${ vo.id }</td>
			<td>${ vo.pwd }</td>
			<td>${ vo.email }</td>
			<td>${ vo.addr }</td>
			
			<td>
				<input type="button" value="삭제" onclick="del('${vo.idx}');">
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>
















