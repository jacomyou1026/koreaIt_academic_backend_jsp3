<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${empty sessionScope.vo }">
   		<script type="text/javascript">

   		alert('로그인 후 이용 가능한 페이지 입니다.');
   		location.href ="login_form.jsp";
   			
	</script>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
</body>
</html>