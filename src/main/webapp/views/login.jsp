<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create session</title>
</head>
<body>

	<%=(request.getParameter("loginRequired") != null) ? "Login required" : ""%>
	<%=(request.getParameter("loginFailed") != null) ? "Username or password incorrect" : ""%>
	<form method="post" action="login">
		<input type="text" name="username" placeholder="Username here">
		<input type="password" name="password" placeholder="Password here">
		<input type="submit">
	</form>
</body>
</html>