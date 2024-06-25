<%@page import="himedia.myportal.repositories.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portal</title>
<link type="text/css" 
	rel="stylesheet" 
	href="<c:url value="/css/guestbook.css"/>">
</head>

<body>
  <div id="container">
  
    <!-- header include -->
    <c:import url="/WEB-INF/views/includes/header.jsp">
    	<c:param name="param1" value="param1"/>
    	<c:param name="param2" value="param2"/>
    </c:import>

	<!-- navigation include -->
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
    
	<div id="wrapper">
      <div id="content">
			<!-- Content 영역 -->
			<form action="<c:url value = "/guestbook/write"/>" method="POST">
			<table border=1 width=500>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
				</tr>
				<tr>
					<td colspan=4 align=right><input type="submit" VALUE="확인"></td>
				</tr>
			</table>
			</form>
			<br/>

			<c:forEach items= "${list }" var="vo" varStatus="status">
			<table width=510 border=1>
				<tr>
					<td>[${vo.no }] ${status.index }</td>
					<td>${vo.name}</td>
					<td>${vo.date}</td>
					<td><a href="<c:url value="/guestbook?a=passconfirm&no=${vo.no }"/>">수정</a></td>
					<td><a href="<c:url value="/guestbook/delete/${vo.no }"/>">삭제</a></td>
				</tr>
				<tr>
					<td colspan=5>${vo.content}</td>
				</tr>
			</table>
			</c:forEach>
        	<br/>
      </div>
	</div>
	
	<!-- footer include -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
	
  </div>
</body>
</html>