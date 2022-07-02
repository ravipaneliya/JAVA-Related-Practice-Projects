<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>LOGIN - FLY AWAY</title>
  <style>
    .actiontxt { 
      color: black;
      font-size:20px;
    }
  </style>
</head>
<%
	int isadmin=0;
	if(request.getParameter("isadmin") != null){
		isadmin = Integer.parseInt(request.getParameter("isadmin"));
	}
	String loginerror = "";
	if(request.getParameter("loginerror") != null){
		loginerror = request.getParameter("loginerror");
	}
%>
<body style="background-color: #82b2c0">
  <table style="background-color: grey" cellspacing="10" align="right" width="100%">
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
    </tr>
  </tbody>
</table>

  <form action="login" method="post">
      <br><br><br><br>
      <table>
        <tr>
          <td style="font-size:15px;">UserName</td>
          <td><input type="text" name="username" required/></td>
        </tr>
          <tr>
          <td style="font-size:15px;">Password</td>
          <td><input type="password" name="password" required/><br><b><%=loginerror %></b></td>
        </tr>
        </tr>
          <tr>
          <td style="font-size:15px;"></td>
          <td><input type="number" name="isadmin" value="<%=isadmin %>" hidden/></td>
        </tr>
      </table>
      <input type="submit" value="Login" class="actiontxt"/>
  </form>

</body>
</html>
