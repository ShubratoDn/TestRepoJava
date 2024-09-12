<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View session</title>
</head>
<body>
	Session value is: <%=session.getAttribute("username") %>
	<br>
	<a href="/remove-session">Logout</a>
</body>
</html>