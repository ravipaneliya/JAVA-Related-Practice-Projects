<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.flyaway.model.Ticket" %>
<!DOCTYPE html>
<html>
<head>
  <title>SHOW TICKET - FLY AWAY</title>
  <style>
    .actiontxt {
      background-color: transparent;
      color: #296c86;
      font-size:20px;
    }
  </style>
</head>
<body style="background-image: url('resources/theme.jpg')">
<%
	String user;
	int userid = 0;
	if(session != null && session.getAttribute("user") != null && session.getAttribute("userid") != null){
		user = (String) session.getAttribute("user");
		userid = (int) session.getAttribute("userid");
	}
	
	Ticket tkt = null;
	if(request != null && request.getAttribute("ticket") != null){
		tkt = (Ticket) request.getAttribute("ticket");
	}
%>
	<%
		if(userid == 0){
	%>
		<jsp:forward page="home.jsp"></jsp:forward>
	<%
		}
	%>
<table cellspacing="10" align="right" width="100%">
  <tbody>
    <tr>
      <td width="70%"></td>
      <td>
        <a href="home.jsp">
          <button class="actiontxt">HOME</button>
        </a>
      </td>
      <td>
        <a href="bookflight.jsp">
          <button class="actiontxt">BOOK FLIGHT</button>
        </a>
      </td>
      <% if(userid == 0) {%>
	      <td>
	        <a href="login.jsp?isadmin=1">
	          <button class="actiontxt">ADMIN LOGIN</button>
	        </a>
	      </td>
	      <td>
	        <a href="login.jsp?isadmin=0">
	          <button class="actiontxt">CUSTOMER LOGIN</button>
	        </a>
	      </td>
      <% } else { %>
      		<td>
	        <a href="logout.jsp">
	          <button class="actiontxt">LOGOUT</button>
	        </a>
	      </td>
      <% } %>
    </tr>
  </tbody>
</table>
<br><br><br><br><br>
	<% if(tkt != null){%>
		<table cellspacing="10" border="3" align="center" width="30%">
			<tr><td><b>Booking ID</b></td><td><%= tkt.getBookingID()%></td></tr>
			<tr><td><b>Customer Name</b></td><td><%= tkt.getCustomerName()%></td></tr>
			<tr><td><b>Phone No</b></td><td><%= tkt.getPhoneNo()%></td></tr>
			<tr><td><b>Booking Class</b></td><td><%= tkt.getBookingClass()%></td></tr>
			<tr><td><b>Travel Date</b></td><td><%= tkt.getTravelDate()%></td></tr>
			<tr><td><b>Booking Date</b></td><td><%= tkt.getBookingDate()%></td></tr>
			<tr><td><b>No Of Traveler</b></td><td><%= tkt.getTravellers()%></td></tr>
			<tr><td><b>Total Fare</b></td><td><%= tkt.getTotalFare() %></td></tr>
		</table>
	<%}%>
</body>
</html>