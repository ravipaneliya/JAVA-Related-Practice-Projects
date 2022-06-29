<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.simplilearn.demo.Products"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form action="save">
		Product Name : <input type="text" name="pname"><br />
		<br /> Product Price : <input type="text" name="price"><br />
		<br /> Product Desc : <input type="text" name="pdesc"><br />
		<br /> <input type="submit" value="Add Product">
	</form>
	<br>
	
	<h1>Displaying Product List</h1>
	<table border="1" width="500">
		<tr bgcolor="00FF7F">
			<!-- <td><b>ID</td> -->
			<td><b>Product Name</td>
			<td><b>Price</td>
			<td><b>Description</td>
		</tr>
		<%
		if (request != null && request.getAttribute("products") != null) {
			List<Products> products = (List<Products>) request.getAttribute("products");
			for (Products p : products) {%>
				<tr>
					<%-- <td><%=p.getId()%></td> --%>
					<td><%=p.getName()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getDescription()%></td>
				</tr>
			<%}
		}%>
	</table>
</body>
</html>