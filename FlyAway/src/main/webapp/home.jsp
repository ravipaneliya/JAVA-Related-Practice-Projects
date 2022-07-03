<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>FLY AWAY</title>
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
	String user;
	int userid = 0;
	int isadmin = 0;
	if (session.getAttribute("user") != null && session.getAttribute("userid") != null) {
		user = (String) session.getAttribute("user");
		userid = (int) session.getAttribute("userid");
		isadmin = (int) session.getAttribute("isadmin");
	}
	%>
	<table cellspacing="10" align="right" width="100%">
		<tbody>
			<tr>
				<td width="20%"></td>
				<td><a href="home.jsp">
						<button class="actiontxt">HOME</button>
				</a></td>
				<td><a href="bookflight.jsp">
						<button class="actiontxt">BOOK FLIGHT</button>
				</a></td>
				<%
				if (userid == 0) {
				%>
				<td><a href="login.jsp?isadmin=1">
						<button class="actiontxt">ADMIN LOGIN</button>
				</a></td>
				<td><a href="login.jsp?isadmin=0">
						<button class="actiontxt">CUSTOMER LOGIN</button>
				</a></td>
				<%
				} else {
				%>
				<% if(isadmin == 1) {%>
					<td><a href="showflights">
						<button class="actiontxt">SHOW FLIGHTS</button>
					</a></td>
				<% }%>
				<td><a href="showbookings">
						<button class="actiontxt">SHOW BOOKINGS</button>
				</a></td>
				<td><a href="changepass.jsp">
						<button class="actiontxt">CHANGE PASSWORD</button>
				</a></td>
				<td><a href="logout.jsp">
						<button class="actiontxt">LOGOUT</button>
				</a></td>
				<%
				}
				%>
			</tr>
		</tbody>
	</table>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<p align="center" style="color: white; font-size: 70px;">
		<b>WELCOME TO FLYAWAY</b>
	</p>
	<p align="center" style="color: white; font-size: 40px;">Your
		journey is one click away</p>

	<br>
	<br>


	<p align="center">
		<a href="bookflight.jsp">
			<button
				style="background-color: transparent; color: lightskyblue; font-size: 30px;">CLICK
				HERE TO BOOK FLIGHT</button>
		</a>
	</p>

</body>
</html>