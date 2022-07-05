<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.model.FlightDetails"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>FLY AWAY - REGISTER NEW CUSTOMER</title>
<style>
.actiontxt {
	background-color: transparent;
	color: #296c86;
	font-size: 20px;
}
</style>
</head>
<body style="background-image: url('resources/theme.jpg')">
	<%
	String heading = "REGISTER NEW CUSTOMER TO BOOK TICKET";
	boolean isadd = true;
	int result = 0;
	if (request.getAttribute("result") != null) {
		result = (int) request.getAttribute("result");
	}
	if (result == 1) {
		heading = "NEW CUSTOMER SUCCESSFULLY REGISTERED.. ENJOY BOOKING..!";
		isadd = false;
	} else if (result == 2) {
		heading = "REGISTRATION FAILED...!<br>PLEASE TRY AGAIN..";
	} else if (result == 3) {
		heading = "PASSWORD AND RETYPE PASSWORD DOESN'T MATCH...!<br>PLEASE TRY AGAIN..";
	}
	%>

	<table cellspacing="10" align="right" width="100%">
		<tbody>
			<tr>
				<td width="50%"></td>
				<td><a href="home.jsp">
						<button class="actiontxt">HOME</button>
				</a></td>
				<td><a href="login.jsp?isadmin=1">
						<button class="actiontxt">ADMIN LOGIN</button>
				</a></td>
				<td><a href="login.jsp?isadmin=0">
						<button class="actiontxt">CUSTOMER LOGIN</button>
				</a></td>
			</tr>
		</tbody>
	</table>

	<br>
	<br>
	<br>

	<h2><%=heading%></h2>

	<%
	if (result != 1) {
	%>
	<form action="registercustomer" method="post">
		FULL NAME <input type="text" name="fname" required /><br> <br>
		E-MAIL <input type="text" name="email" required /><br> <br>
		PASSWORD <input type="password" name="pass1" required /><br> <br>
		RETYPE PASSWORD <input type="password" name="pass2" required /><br>
		<br> PHONE NO <input type="number" name="phoneno" /><br> <br>
		<input type="submit" value="REGISTER"
			style="background-color: transparent; color: white; font-size: 30px;" />
	</form>
	<%
	}
	%>
</body>
</html>