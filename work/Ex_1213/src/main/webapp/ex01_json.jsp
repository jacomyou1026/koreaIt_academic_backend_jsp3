<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//JSON : Javascript Object Notation
//--서로다른 프로그램에서 데이터를 교환하기 위한표기법
//
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//json 표기법은 Map처럼(Map은 아님) key : value형태로 값을 저장한다.

	//단순 json
	var p = {
		'name' : '일기동',
		'age' : 20,
		'tel' : '010-1111-1111'
	}
	document.write("이름 : " + p['name'] + "<br>");
	document.write("나이 : " + p.age + "<br>");
	document.write("전화 : " + p.tel + "<br>");
	document.write("<hr>");

	//json 배열
	var p_arr = [ {
		'name' : '홍길동',
		'age' : 30
	}, {
		'name' : '박길동',
		'age' : '24'
	} ];
	
	document.write("::학생정보::<br>");
	for (var i = 0; i < p_arr.length; i++) {
		document.write('이름 : ' + p_arr[i].name+"<br>");
		document.write('나이: ' + p_arr[i].age+"<br>");
	}
	document.write("<hr>");
	//json혼합형
	var c = {
		'name':'web개발3','start':'21-09-01','end':'22-02-01'
		,'sub':['java','jsp','android'],
		'student':[
			{'name':'뷔','age':'19'},
			{'name':'진','age':'22'},
			{'name': 'rm','age':'23'}
		]
	};
	
	document.write("과정명 : "+c.name+" / "+
			"시작일 : "+c.start+" / "+
			"종료일 : "+c.end);
	
	document.write("/ 수업과목 :")
	for (var i = 0; i < c.sub.length; i++) {
		i==c.sub.length-1?document.write(c.sub[i] +" <br>"):document.write(c.sub[i] +"/ ");
	}
	
	document.write("학생1 : "+c.student[0].name+" / "+c.student[0].age+"<br>");
	document.write("학생2 : "+c.student[1].name+" / "+c.student[1].age+"<br>");
	
	
</script>
</head>
<body>

</body>
</html>