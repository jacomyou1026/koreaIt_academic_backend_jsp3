<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//파라미터를 수신할 때의 인코딩 타입
	//post방식으로 파라미터가 전달되면 한글이 깨지는데,
	//이것을 utf-8형식으로 재조합해서 받아야 한다.
	
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int no = Integer.parseInt(request.getParameter("no"));
	int kor =Integer.parseInt(request.getParameter("kor"));
	int eng =Integer.parseInt(request.getParameter("eng"));
	int mat =Integer.parseInt(request.getParameter("mat"));
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(f){
		var no = f.no.value;
		var name= f.name.value.trim();
		var kor= f.kor.value.trim();
		var eng= f.eng.value.trim();
		var mat= f.mat.value.trim();
		
		if(name ==''){
			alert('이름을 입력해주세요');
			return
		}		
		if(kor ==''){
			alert('국어점수를 입력해주세요');
			return
		}		
		if(eng ==''){
			alert('영어점수를 입력해주세요');
			return
		}		
		if(mat ==''){
			alert('수학점수를 입력해주세요');
			return
		}		
		var patt  =/^[0-9]+$/;
		if(!patt.test(kor) || kor<0||kor>100 ){
			alert("성적은 0~100사이의 정수입니다.")
			return;
		}
		
		if(!patt.test(eng) || eng<0||eng>100 ){
			alert("성적은 0~100사이의 정수입니다.")
			return;
		}
		
		if(!patt.test(mat) || mat<0||mat>100 ){
			alert("성적은 0~100사이의 정수입니다.")
			return;
		}
		

		
		f.action = "update_result.jsp?"
		f.submit();
		
	}	
</script>
</head>
<body>
	<form>
		<input type="hidden" value="<%=no %>" name="no">
		<table border=1>
			<caption>::학생 정보 수정하기::</caption>
			<tr>
				<th>이름</th>
				<td><input value="<%=name %>" name="name"></td>
			</tr>
			<tr>
				<th>국어점수</th>
				<td><input value="<%=kor %>" name="kor"></td>
			</tr>
			<tr>
				<th>영어점수</th>
				<td><input value="<%=eng%>" name="eng"></td>
			</tr>
			<tr>
				<th>수학점수</th>
				<td><input value="<%=mat %>" name="mat"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value ="수정"
						onclick="send(this.form);">
					<input type="button" value ="취소"
					onclick="location.href='db_sungtb.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>