<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>LOGOUT - FLY AWAY</title>
</head>
<%
	request.getSession().invalidate();
%>
<body>
  <jsp:forward page="home.jsp"></jsp:forward>
</body>
</html>
