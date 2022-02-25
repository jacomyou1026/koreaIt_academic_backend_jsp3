<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>

<script type="text/javascript">
	function update1(f){
		f.submit();
	}
	function del(f,f1){
		if(!confirm(f+"고객님을 삭제하시겠습니까?")){
			return;
		}
		var url = "delet.do";
		var param = "gobun="+f1;
		sendRequest(url,param,delFun,"GET");
		
	}
	function delFun(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//			result ="[{'p':'yes'}]"; 

			var data1 =xhr.responseText;
			var json1 = eval(data1);
			
			if(json1[0].p =='yes'){
				alert('완전히 삭제되었습니다.');
			}else{
				alert('삭제를 못하였습니다.');
			}
			
			location.href="list.do";
			
		}
	}

</script>
</head>
<body>
	<table border=1>
		<caption>고객 조회 정보</caption>
		<tr>
			<th>고객번호</th>
			<th>고객이름</th>
			<th>고객주소</th>
			<th>고객주민번호</th>
			<th>비고</th>
		</tr>
		<c:forEach var="vo" items="${mylist }">
			<tr>
				<td>${vo.gobun }</td>
				<td>${vo.goname}</td>
				<td>${vo.goaddr }</td>
				<td>${vo.gojumin}</td>
				<td><input type="button" value="삭제"
					onclick="del('${vo.goname}','${vo.gobun}');">
					<form action="update1.do">
						<input type="button" value="수정" onclick="update1(this.form);">
						<input type="hidden" value="${vo.gobun }" name="gobun"> <input
							type="hidden" value="${vo.goname}" name="goname"> <input
							type="hidden" value="${vo.goaddr}" name="goaddr"> <input
							type="hidden" value="${vo.gojumin}" name="gojumin">
					</form></td>
			</tr>

		</c:forEach>
	
		<tr>
			<td colspan="5" align="center">
			<input type="button" value="추가"
				onclick="location.href='Insert.jsp'"></td>
		</tr>
		

	</table>
</body>
</html>