<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
</head>
<body>
	<h3>User Details</h3>
	<%-- <table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Date</th>
		</tr>
		<c:forEach var="p" items="${list}">
			<tr>
			<form action="updaterecord">
				<td><input type="text" name = "id" value="${p.id}" hidden></td>
				<td><input type="text" name = "name" value="${p.name}"></td>
				<td><input type="text" name = "price" value="${p.price}"></td>
				<td><input type="text" name = "da" value="${p.dateAdded}"></td>
				<td><input type="submit">Update</td>
			</form>
		</tr>
		</c:forEach>
	</table> --%>
</body>
</html>