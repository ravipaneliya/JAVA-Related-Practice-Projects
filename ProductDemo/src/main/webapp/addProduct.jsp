<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form action="save">
		Product Name	: <input type="text" name="pname"><br/><br/>
		Product Price	: <input type="text" name="price"><br/><br/>
		Product Desc	: <input type="text" name="pdesc"><br/><br/>
		<input type = "submit" value = "Add Product">
	</form>
	<br>
	<h3>
		<a href="show">FETCH PRODUCTS</a>
	</h3>
</body>
</html>