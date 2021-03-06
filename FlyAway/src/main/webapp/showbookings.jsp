<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>SHOW TICKET - FLY AWAY</title>
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
	if (session != null && session.getAttribute("user") != null && session.getAttribute("userid") != null) {
		user = (String) session.getAttribute("user");
		userid = (int) session.getAttribute("userid");
		isadmin = (int) session.getAttribute("isadmin");
	}

	Ticket tkt = null;
	if (request != null && request.getAttribute("ticket") != null) {
		tkt = (Ticket) request.getAttribute("ticket");
	}

	ArrayList<Ticket> tickets = null;
	if (request != null && request.getAttribute("tickets") != null) {
		tickets = (ArrayList<Ticket>) request.getAttribute("tickets");
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
				<td width="20%"></td>
				<td><a href="home.jsp">
						<button class="actiontxt">HOME</button>
				</a></td>
				<td><a href="bookflight.jsp">
						<button class="actiontxt">BOOK FLIGHT</button>
				</a></td>
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
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%
	if (tkt != null) {
	%>
	<table cellspacing="10" border="3" align="center" width="30%">
		<tr>
			<td><b>Booking ID</b></td>
			<td><%=tkt.getBookingID()%></td>
		</tr>
		<tr>
			<td><b>Customer Name</b></td>
			<td><%=tkt.getCustomerName()%></td>
		</tr>
		<tr>
			<td><b>Phone No</b></td>
			<td><%=tkt.getPhoneNo()%></td>
		</tr>
		<tr>
			<td><b>Booking Class</b></td>
			<td><%=tkt.getBookingClass()%></td>
		</tr>
		<tr>
			<td><b>Travel Date</b></td>
			<td><%=tkt.getTravelDate()%></td>
		</tr>
		<tr>
			<td><b>Booking Date</b></td>
			<td><%=tkt.getBookingDate()%></td>
		</tr>
		<tr>
			<td><b>No Of Traveler</b></td>
			<td><%=tkt.getTravellers()%></td>
		</tr>
		<tr>
			<td><b>Total Fare</b></td>
			<td><%=tkt.getTotalFare()%></td>
		</tr>
	</table>
	<%
	}
	%>

	<%
	if (tickets != null) {
		if (tickets.size() == 0) {
	%>
	<h1>
		<b>No Booking Found In Your Account.</b>
	</h1>
	<%
	} else {
	%>
	<table cellspacing="10" border="1" align="center" width="70%">
		<th><b>Booking ID</b></th>
		<th><b>Customer Name</b></th>
		<th><b>Phone No</b></th>
		<th><b>Booking Class</b></th>
		<th><b>Travel Date</b></th>
		<th><b>Booking Date</b></th>
		<th><b>No Of Traveler</b></th>
		<th><b>Total Fare</b></th>
		<%
		for (Ticket tk : tickets) {
		%>
		<tr>
			<td align="center"><%=tk.getBookingID()%></td>
			<td align="center"><%=tk.getCustomerName()%></td>
			<td align="center"><%=tk.getPhoneNo()%></td>
			<td align="center"><%=tk.getBookingClass()%></td>
			<td align="center"><%=tk.getTravelDate()%></td>
			<td align="center"><%=tk.getBookingDate()%></td>
			<td align="center"><%=tk.getTravellers()%></td>
			<td align="center"><%=tk.getTotalFare()%></td>
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
</body>
</html>