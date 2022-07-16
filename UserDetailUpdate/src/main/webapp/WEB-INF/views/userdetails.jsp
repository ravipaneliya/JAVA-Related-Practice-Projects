<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Data</title>
</head>
<body>
	<h3>User Details</h3>
	<c:forEach var="p" items="${list }">
		<form action="updaterecord">
			<input type="text" name="userid" value="${p.id}" hidden> ${p.id}<br>
			<br> <input type="text" name="name" value="${p.name}"> <br>
			<br> <input type="text" name="city" value="${p.city}"> <br>
			<br> <input type="submit" value="Update">
		</form>
	</c:forEach>
</body>
</html>