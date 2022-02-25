<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
String[] fruit = { "사과", "배", "참외", "복숭아" };
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (arr[0] == 1) {
	%>
	<h2><%=arr[0]%></h2>
	<%
	}
	%>
	<hr>
	<ul>
		<%
		for (int i = 0; i < fruit.length; i++) {
		%>
		<li><%=fruit[i]%></li>
		<%
		}
		%>

	</ul>
	<hr>
	<!-- 테이블을 사용하겨 구구단 출력 -->

	<h1>구구단</h1>

	<table border="1">
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
			for (int j = 2; j <= 9; j++) {
			%>
			<td><%=j%> X <%=i%> = <%=j * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>

	table

</body>
</html>