<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.model.FlightDetails"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>FLY AWAY - ADD NEW FLIGHT</title>
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

	String heading = "ADD NEW FLIGHT DETAILS";
	boolean isadd = true;
	if (request.getAttribute("success") != null) {
		heading = "";
		isadd = false;
	}

	if (request.getAttribute("fail") != null) {
		heading = "NEW FLIGHT INSERTION FAILED...!<br>PLEASE TRY ADDING NEW FLIGHT DETAILS AGAIN..";
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

	<h2><%=heading%></h2>

	<%
	if (isadd) {
	%>
	<form action="addnewflight" method="post">
		FLIGHT NUMBER <input type="text" name="flightnumber" required /><br>
		<br> AIR LINE <input type="text" name="airline" required /><br>

		<br> WEEK DAYS : Sun<input type="checkbox" name="0" /> Mon<input
			type="checkbox" name="1" /> Tue<input type="checkbox" name="2" />
		Wed<input type="checkbox" name="3" /> Thu<input type="checkbox"
			name="4" /> Fri<input type="checkbox" name="5" /> Sat<input
			type="checkbox" name="6" /> <br> <br> SRC AIRPORT CODE <input
			type="text" name="src_code" required /><br> <br> DEST
		AIRPORT CODE <input type="text" name="dest_code" required /><br>
		<br> ECONOMY FARE <input type="number" name="ecfare" /><br>
		<br> PREMIUM FARE <input type="number" name="prfare" /><br>
		<br> BUSINESS FARE <input type="number" name="bufare" /><br>
		<br> <input type="submit" value="SAVE FLIGHT"
			style="background-color: transparent; color: white; font-size: 30px;" />
	</form>
	<%
	}
	%>
</body>
</html>