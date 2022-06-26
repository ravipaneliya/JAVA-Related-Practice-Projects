<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="err.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%
	String usr = request.getParameter("usr");
	String pwd = request.getParameter("pwd");
	
	if(usr!=null && pwd != null && usr.length()>0 && pwd.length()>0){
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Home Page", "success.jsp");
	} else {
		throw new RuntimeException("Invalid Username or Password..!!");
	}
%>
<br/>
	<form action="login.jsp">
		User : <input type = "text" name = "usr"><br/><br/>
		Password : <input type = "password" name = "pwd"><br/><br/><br/>
		<input type = "submit" value = "LOGIN">
	</form>
</body>
</html>