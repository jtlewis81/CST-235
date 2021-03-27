<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Form</title>
</head>
<body>
	<form action="TestServlet" method="post">
	  <label for="firstname">First name:</label><br>
	  <input type="text" id="firstname" name="firstname" value=""><br>
	  <label for="lastname">Last name:</label><br>
	  <input type="text" id="lastname" name="lastname" value=""><br><br>
	  <input type="submit" value="Submit">
	</form>
</body>
</html>