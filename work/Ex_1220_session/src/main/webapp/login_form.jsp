<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script type="text/javascript">
 function send(f){
	 var id = f.id.value.trim();
	 var pwd = f.pwd.value.trim();
	 
	if(id==''){
		alert('아이디를 입력해주세요');
		return;
	}
	
	if(pwd==''){
		alert('비밀번호를 입력해주세요');
		return;
	}
	
	//id와 pwd를 Ajax를 통해 서버로 전달
	var url ="login.do";
	//encodeURIComponent:파라미터에 @,!와 같은 특수문자가 포함되어 있는 경우
	//이를 정상적으로 인코딩하기 위한 메서드
	var param = "id="+id+"&pwd="+ encodeURIComponent(pwd);
	sendRequest(url,param,resFun,"POST");
 }
 //Ajax통신을 마치고 자동으로 호출되는 콜백메서드
 function resFun(){
	 if(xhr.status ==200 && xhr.readyState ==4){
		 var data = xhr.responseText;
		 var json = eval(data);
		 //"[{'res':'no_pwd'}]";
		 if(json[0].res == 'no_id'){
			 alert('아이디가 존재하지 않습니다.');
			 return;
		 }else if(json[0].res == 'no_pwd'){
			 alert('비밀번호 불일치');
			 return;
		 }else{
			 location.href="main_content.jsp";
		 }
	 }
 }
</script>

</head>
<body>
	<form action="" >
		<table border="1" align="center">
			<tr>
				<th>아이디</th>
					<td><input name ="id">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type ="password" name ="pwd">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value ="로그인" onclick="send(this.form);">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>