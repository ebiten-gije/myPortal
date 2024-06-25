
<%@page import="himedia.myportal.repositories.dao.GuestbookDaoImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방명록</title>
</head>
<body>

<c:set var="dbuser" value="${initParam.dbuser}" scope="application"/>
<c:set var="dbpass" value="${initParam.dbpass}" scope="application"/>

<c:set var="no" value="${param.id}" />
<c:set var="password" value="${param.password}" />

<c:set var="dao" value="${GuestbookDaoOI(dbuser, dbpass)}" />
<c:set var="vo" value="${dao.search(no, password)}" />
<c:choose>
	<c:when test="${not empty vo }">
		<h4>수정 페이지</h4>
		<form action="<c:url value='/guestbook'/>" method="POST">
		<input type='hidden' name="a" value="update">
		<input type='hidden' name="no" value="${no }">
		<table border=1 width=500>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5>${vo.content }</textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
		</form>
		<p><a href="<c:url value='/guestbook'/>">메인으로 돌아가기</a></p>
	</c:when>

	<c:otherwise>
		<h3>비밀번호가 틀렸습니다</h3>
		<h3>비밀번호를 확인하고 다시 시도해주세용</h3>
		<p><a href="<c:url value='/guestbook'/>">메인으로 돌아가기</a></p>
	</c:otherwise>
</c:choose>
</body>
</html>