<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Join Form</title>
<link type="text/css" 
	rel="stylesheet" 
	href="<c:url value="/css/guestbook.css"/>">
	
<script src="<c:url value= "/javascript/users.js"/>"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		
		<div id="wrapper">
			<div id="content">
			
			<h1>Join Form</h1> 
			
			<form
				id="join-form"
				name="registerForm" 
				action="<c:url value="/users/join"/>"
				method="POST"
			>
			<input type="hidden" name="a" value="join">
		
			<label for="name">이름</label>
			<input name="name" type="text" placeholder="이름을 입력하십시오"><br>
	
			<label for="password">비밀번호</label>
			<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
			<label for="email">이메일</label>
			<input type="text" name="email" placeholder="이메일을 입력하십시오.">
			
			<input type="button" id="check-email" data-target="<c:url value="/users/checkEmail"/>"
				value ="이메일 중복 체크"/>
			<input type="hidden" name ="emailCheck" value="n"/>
			<br>
			
	
			<label for="gender">성별</label>
			<input type="radio" name="gender" value="M" checked>남성</radio>
			<input type="radio" name="gender" value="F">여성</radio><br>
			
			
			<label for ="agree">약관 동의</label>
			<input type ="checkbox" id="agree" name="agree" value="n"/>
 			<input type="submit" value="전송"> 
	
			</form>
			<!-- TODO: 폼 검증(Validation) -->
			
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
		
	</div>
</body>
</html>