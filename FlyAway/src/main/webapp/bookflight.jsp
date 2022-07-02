<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.flyaway.model.FlightDetails"%>
<%@page import="java.util.List"%>
<html>
<head>
  <title>BOOK FLIGHT - FLY AWAY</title>
  <style>
    .actiontxt { 
      color: black;
      font-size:20px;
    }
  </style>
</head>
<body style="background-color: #82b2c0">
<%
String user;
int userid = 0;
if(session.getAttribute("user") != null && session.getAttribute("userid") != null){
	user = (String) session.getAttribute("user");
	userid = (int) session.getAttribute("userid");
}
%>
  <table style="background-color: grey" cellspacing="10" align="right" width="100%">
  <tbody>
    <tr>
      <td width="60%"></td>
      <td>
        <a href="home.jsp">
          <button class="actiontxt">HOME</button>
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
  
  <br><br><br>

  <form action="searchflights">
    <label for="from">FROM&nbsp;&nbsp;</label>
    <select name="src" id="from">
      <option value="SRT">SRT</option>
      <option value="BOM">BOM</option>
      <option value="BAR">BAR</option>
      <option value="AMD">AMD</option>
      <option value="DEL">DEL</option>
    </select> 
    <label>&nbsp;&nbsp;TO&nbsp;&nbsp;</label>
    <select name="dest" id="to">
      <option value="BOM">BOM</option>
      <option value="SRT">SRT</option>
      <option value="BAR">BAR</option>
      <option value="AMD">AMD</option>
      <option value="DEL">DEL</option>
    </select><br><br>
    Travel Date : <input type="date" name="traveldate" required><br><br>
    No of Traveler : <input type="number" name="travellers" required><br><br>
    <button class="actiontxt">SEARCH FLIGHTS</button>
  </form>
  
		<%
		if (request != null && request.getAttribute("availableflights") != null) {
			List<FlightDetails> flightlist = (List<FlightDetails>) request.getAttribute("availableflights");
			String traveldate = request.getParameter("traveldate");
			
			int traveller = 0;
			if(request.getParameter("travellers")!=null) {
				traveller = Integer.parseInt(request.getParameter("travellers"));
			}
			%>
			<table border="1" width="500">
		  	<tr bgcolor="white">
				<th><b>Flight Number</th>
				<th><b>Airline</th>
				<th><b>TravelDate</th>
				<th><b>Source</th>
				<th><b>Destination</th>
				<th></th>
			</tr>
				<%	for (FlightDetails f : flightlist) {%>
					<tr>
						<td><%=f.getFlight_number()%></td>
						<td><%=f.getAirline()%></td>
						<td><%=traveldate%></td>
						<td><%=f.getSrc_airport_code()%></td>
						<td><%=f.getDest_airport_code()%></td>
	<%
		String params = "fid=" + f.getId() + "&travellers=" + traveller + "&traveldate=" + traveldate
				+ "&ec=" + f.getEconomy_fare() + "&pc=" + f.getPremium_fare() + "&bc=" + f.getBusiness_fare();
	%>
						<td><a href="bookticket.jsp?<%=params%>">
					          <button class="actiontxt">BOOK TICKET</button>
					        </a>
				        </td>
					</tr>
				<% } %>
			</table>
		<% }%>

</body>
</html>
