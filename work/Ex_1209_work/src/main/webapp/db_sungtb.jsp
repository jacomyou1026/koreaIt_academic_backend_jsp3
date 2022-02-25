<%@page import="vo.SungtbVo"%>
<%@page import="java.util.List"%>
<%@page import="dao.SungtbDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%SungtbDAO sd = SungtbDAO.getInstance(); %>

<%List<SungtbVo> sv = sd.selectList();%>



<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function del(no){
		if(confirm("정말 삭제하시겠습니까?") == false){
			//취소버튼 클릭시에는 아무것도 하지 않는다.
			return;
		}else{
		location.href ='sung_del.jsp?no='+no;
		}
		
	}
	function update(f){
		
		f.action = "sung_update.jsp"
		//f.method = "GET" <== 전송방식(기본값 : get);
		f.method = "POST"; // URL에 표시가 되지 않도록 숨겨서 전송
		f.submit();
		
	}
</script>
</head>
<body>
	<table border = "1">
	<caption>학생 정보</caption>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
		<th>순위</th>
		<th>비고</th>
	</tr>
	<%for(int i=0;i<sv.size();i++){ %>
	<tr>
		<td><%=sv.get(i).getNo()%></td>
		<td><%=sv.get(i).getName() %></td>
		<td><%=sv.get(i).getKor() %></td>
		<td><%=sv.get(i).getEng() %></td>
		<td><%=sv.get(i).getMat() %></td>
		<td><%=sv.get(i).getSub_total()%></td>
		<td><%=sv.get(i).getSug_avg() %></td>
		<td><%=sv.get(i).getRank() %></td>
		
		<td>
		<input type = "button" value = "삭제" 
				onclick="del('<%=sv.get(i).getNo()%>');">
		<form action="">
			<input type = "button" value = "수정"
				onclick="update(this.form)">
				
			<input type = "hidden"  value ="<%=sv.get(i).getNo() %>" name = "no">
			<input type = "hidden" value ="<%=sv.get(i).getName()  %>" name = "name">
			<input type = "hidden" value ="<%=sv.get(i).getKor()  %>" name = "kor">
			<input type = "hidden" value ="<%=sv.get(i).getEng()%>" name = "eng">
			<input type = "hidden" value ="<%=sv.get(i).getMat() %>" name = "mat">
		</form>				
		</td>
		
	</tr>
	<%} %>
	<tr align="center">
		<td colspan="9" align="center">
			<input type ="button" value="학생추가" 
			onclick="location.href ='register.jsp'">
		</td>
	</tr>
	</table>
</body>
</html>