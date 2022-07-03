<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>FLY AWAY - CHANGE PASSWORD</title>
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
	if (session.getAttribute("user") != null && session.getAttribute("userid") != null) {
		user = (String) session.getAttribute("user");
		userid = (int) session.getAttribute("userid");
	}
	int result = 0;
	if (request.getAttribute("success") != null) {
		result = 1;
	}
	if (request.getAttribute("fail") != null) {
		result = 2;
	}
	if (userid == 0) {
	%>
	<jsp:forward page="home.jsp"></jsp:forward>
	<%
	}
	%>

	<table cellspacing="10" align="right" width="100%">
		<tbody>
			<tr>
				<td width="50%"></td>
				<td><a href="home.jsp">
						<button class="actiontxt">HOME</button>
				</a></td>
				<td><a href="bookflight.jsp">
						<button class="actiontxt">BOOK FLIGHT</button>
				</a></td>
				<td><a href="showbookings">
						<button class="actiontxt">SHOW BOOKINGS</button>
				</a></td>
				<td><a href="logout.jsp">
						<button class="actiontxt">LOGOUT</button>
				</a></td>
			</tr>
		</tbody>
	</table>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form style="text-align: center;" action="changepass" method="post">
		<%
		if (result == 0 || result == 2 || result == 3) {
		%>
		OLD PASSWORD : <input type="password" name="oldpass" required><br>
		<br> NEW PASSWORD : <input type="password" name="newpass"
			required><br>
		<br> RETYPE PASSWORD : <input type="password" name="retypepass"
			required><br>
		<br>
		<%
		if (result == 2) {
		%>
		<p style="font-style: italic; color: red">
			<b>Invalid Old Password.</b>
		</p>
		<br>
		<br>
		<%
		}
		%>
		<%
		if (result == 3) {
		%>
		<p style="font-style: italic; color: red">
			<b>New-Retype password not match.</b>
		</p>
		<br>
		<br>
		<%
		}
		%>
		<input type="submit" value="Update Password" class="actiontxt" />
		<%
		} else if (result == 1) {
		%>
		<p style="font-style: italic; color: green">
			<b>Password Updated Successfully. Enjoy Booking - Happy Journey.</b>
		</p>
		<br>
		<br>
		<%
		}
		%>
	</form>
</body>
</html>