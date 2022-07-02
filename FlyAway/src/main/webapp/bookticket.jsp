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
	int fid = Integer.parseInt(request.getParameter("fid"));
	String traveldate = request.getParameter("traveldate");
	int traveller = Integer.parseInt(request.getParameter("travellers"));
	String ec = request.getParameter("ec");
	String pc = request.getParameter("pc");
	String bc = request.getParameter("bc");
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
  
  <br><br><br><br><br><br>

  <form action="confirmbooking">
  	<input type="number" name="fid" value = "<%=fid%>" hidden><br>
    SELECT CLASS&nbsp;&nbsp;
    <select name="seatclass" id="seatclass">
      <option value="<%=ec %>">Economy - <%=ec %></option>
      <option value="<%=pc %>">Premium - <%=pc %></option>
      <option value="<%=bc %>">Business - <%=bc %></option>
    </select><br><br>
    TRAVEL DATE : &nbsp;<b><%= traveldate%> </b><input type="date" name="traveldate" value="<%= traveldate%>" hidden><br><br>
    NO OF TRAVELER : &nbsp; <b><%= traveller%> </b><input type="number" name="travellers" value="<%=traveller%>" size="3" hidden><br><br>
    <button class="actiontxt">CONFIRM BOOKING</button>
  </form>
</body>
</html>
