<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="footer.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here.</title>
<link rel="stylesheet" type="text/css"	href="/ShoppingCart/css/signin.css">
</head>
<body>

	<form action="validate.jsp" method="post">
		<div class=container>
			<br><br> 
			<label>Email</label><br> 
			<input	type="text" placeholder="Enter Email" name="email" required>
			<br><br>
			
			 <label>Password</label><br> 
			 <input type="password" placeholder="Enter Password" name="password" required><br>
			<br>
			
			<br> <input id="submit" type="submit" value="Login"><br>
			<br> <a id="right" href="register.jsp">New User?</a> 
			<a id="left" href="forgotPassword.jsp">Forgot Password?</a>
		</div>

	</form>


</body>
</html>