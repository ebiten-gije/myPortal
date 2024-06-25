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
	<form method="post" action="<c:url value='/guestbook/'/>">
	<input type='hidden' name="id" value="<c:out value='${param.no }'/>">
	<table>
		<tr>
			<td>수정하기</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="<c:url value="/guestbook"/>">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
	
</body>
</html>