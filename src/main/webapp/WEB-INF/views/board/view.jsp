<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" 
	rel="stylesheet" 
	href="<c:url value="/css/guestbook.css"/>">
</head>
<body>
	
	<!-- header include -->
    <c:import url="/WEB-INF/views/includes/header.jsp">
    	<c:param name="param1" value="param1"/>
    	<c:param name="param2" value="param2"/>
    </c:import>
    
    <!-- navigation include -->
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	
	<table border="1" width="640">
		<tr>
			<td colspan="2"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th colspan="2">글보기</th>
		</tr>
		<tr>
			<td>제목</td>
			<td>${boardVo.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<div>
					${boardVo.content }
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<c:url value="/board"/>">글목록</a>
				<c:if test="${not empty authUser}">
					<c:if test="${authUser.no == vo.userNo }">
						<a href="<c:url value="/board/${vo.no }/modify"/>">수정</a>
						<a href="<c:url value="/board/${vo.no }/delete"/>">삭제</a>
					</c:if> 
				</c:if>
			</td>
		</tr>
	</table>
	
	<!-- footer include -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>

</body>
</html>
