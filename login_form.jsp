<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- Ajax사용을 위한 자바스크립트 파일 참조 -->
	<script src="js/httpRequest.js"></script>

	<script>
		function send(f){
			
			var id = f.id.value.trim();
			var pwd = f.pwd.value.trim();
			
			if( id == '' ){
				alert("아이디는 필수");
				return;
			}
			
			if( pwd == '' ){
				alert("비번은 필수");
				return;
			}
			
			//id와 pwd를 Ajax를 통해 서버로 전달
			var url = "login.do";
			
			//encodeURIComponent : 파라미터에 @, !와 같은 특수문자가 포함되어 있는경우
			//이를 정상적으로 인코딩 하기 위한 메서드
			var param = "id="+id+"&pwd="+ encodeURIComponent(pwd);
			
			sendRequest(url, param, resFn, "POST");
			
		}//sned()
		
		//Ajax통신을 마치고 자동으로 호출되는 콜백메서드
		function resFn(){
			//"[{'res':'clear'}]"
			//"[{'res':'no_id'}]"
			//"[{'res':'no_pwd'}]"
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				var data = xhr.responseText;
				alert(data);
			}
		}
		
	</script>
</head>

<body>
	<form>
		<table border="1" align="center">
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" onclick="send(this.form);">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>

















