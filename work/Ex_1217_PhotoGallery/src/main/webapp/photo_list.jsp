<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		 function del(f){
			 var idx = f.idx.value;
			 var pwd = f.pwd.value; //원본 비밀번호
			 var pwd2 =f.pwd2.value.trim();//삭제를 위한 입력받은 비밀번호
			 if(pwd!=pwd2){
				 alert(pwd);
				 alert("비밀번호가 일치하지 않습니다.");
				 return;
			 }
				 
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			
			location.href ="photo_del.do?idx="+idx;
		 }
		 
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/photo.css">
</head>
<body>
	<div id ="main_box">
		<h1>:::PhotoGallery:::</h1>
		<div align="center">
			
			<input type="button" value ="사진업로드" onclick="location.href ='photo_insert_form.jsp'">
		</div>
		
		<div id ="photo_box">
			<!-- 리스트가 비어있는지 EL표기법을 통해 확인하는 방법 
				1)"${list ==null }
				2) ${list eq null } eq : == / ne :!= / gt :> / lt:< / ge: >= / le : <=
				3)${empty list }
				-->
				
			<c:if test="${empty list }">
				<div align="center">
					아직 등록된 사진이 없습니다.
				</div>
			</c:if>
			<c:forEach begin="0" end="20" var ="vo" items="${list }">
				<div class="photo_type">
					<img alt="" src="img/${vo.filename}">
					<div class ="title">${vo.title }</div>
					<form action="">
						<input type ="hidden" name ="idx" value="${vo.idx}">
						<input type ="hidden" name ="pwd" value="${vo.pwd}">
					
						<div align="center">
							<input type="password" name ="pwd2" size = "10"> 
							<input type="button" value="삭제" onclick="del(this.form);">
						</div>
					</form>
				</div> 
			</c:forEach>
		</div>
	</div>
</body>
</html>