<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="footer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<link rel="stylesheet" type="text/css" href = "/ShoppingCart/css/register.css">
</head>
<body>

<form action = "/ShoppingCart/jsp/create_account.jsp" method ="post">
<div class="box" >
<h4 ><b>Registration</b></h4>

<table>
	<tr><td> Full Name:</td>
	<td> <input type ="text" placeholder ="Enter your full name." name="name" required></td></tr>
	
	<tr><td>Email:</td>
	<td> <input type ="text" placeholder ="Enter your email." name="email" required></td></tr>
	
	<tr><td>Password:</td>
	<td> <input type ="text" placeholder ="Enter the password." name="password" required></td></tr>
	
	<tr><td>Address:</td>
	<td> <input type ="text" placeholder ="Enter your Address." name="address"  required></td></tr>
	
	<tr><td>Phone Number:</td>
	<td> <input type ="number" placeholder ="Enter your phone num." name ="mobile" required></td></tr></table>
	<br><br>
	 <input class="one" type="submit" value ="Register">
      <button class="one" type="reset">Cancel</button>
    

</div>
	</form>

</body>
</html>