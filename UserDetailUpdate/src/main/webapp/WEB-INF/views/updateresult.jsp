<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Result</title>
</head>
<body>
	<c:if test="${result==1}">USER UPDATED SUCCESSFULLY..</c:if>
	<c:if test="${result!=1}">USER UPDATED FAILED..</c:if>
	<br><br><br><br>
	<a href="index.jsp"><b>RETRIEVE / UPDATE USER</a>
</body>
</html>