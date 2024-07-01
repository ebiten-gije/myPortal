<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 result</title>
<link type="text/css" 
	rel="stylesheet" 
	href="<c:url value="/css/board.css"/>"/>
</head>
<body>
<div id = "container">
<!-- header include -->
    <c:import url="/WEB-INF/views/includes/header.jsp">
    	<c:param name="param1" value="param1"/>
    	<c:param name="param2" value="param2"/>
    </c:import>
    
    <!-- navigation include -->
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<img src = "<c:url value="/upload-images/${iamgeFilename }" />" />
	
<!-- footer include -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	
</div>
</body>
</html>