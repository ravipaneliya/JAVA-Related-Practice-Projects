<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.model.FlightDetails"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>FLY AWAY - SHOW FLIGHTS</title>
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

	ArrayList<FlightDetails> flights = new ArrayList();
	if (request != null && request.getAttribute("flights") != null) {
		flights = (ArrayList<FlightDetails>) request.getAttribute("flights");
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
	<%
	if (flights != null) {
		if (flights.size() == 0) {
	%>
	<h1>
		<b>No Flights Inserted Yet.</b>
	</h1>
	<%
	} else {
	%>
	<table cellspacing="10" border="1" align="center" width="70%">
		<th><b>Flight Number</b></th>
		<th><b>AirLine</b></th>
		<th><b>Weekdays</b></th>
		<th><b>SRC Airport Code</b></th>
		<th><b>DEST Airport Code</b></th>
		<th><b>Economy Fare</b></th>
		<th><b>Premium Fare</b></th>
		<th><b>Business Fare</b></th>
		<%
		for (FlightDetails fd : flights) {
		%>
		<tr>
			<td align="center"><%=fd.getFlight_number()%></td>
			<td align="center"><%=fd.getAirline()%></td>
			<td align="center"><%=fd.getWeekdays()%></td>
			<td align="center"><%=fd.getSrc_airport_code()%></td>
			<td align="center"><%=fd.getDest_airport_code()%></td>
			<td align="center"><%=fd.getEconomy_fare()%></td>
			<td align="center"><%=fd.getPremium_fare()%></td>
			<td align="center"><%=fd.getBusiness_fare()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<%
	}
	%>
	<br><br><br>
<p align="center">
		<a href="bookflight.jsp">
			<button
				style="background-color: transparent; color: lightskyblue; font-size: 30px;">CLICK
				HERE TO BOOK FLIGHT</button>
		</a>
	</p>
</body>
</html>