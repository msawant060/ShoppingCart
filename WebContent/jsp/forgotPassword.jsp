<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="footer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href = "/ShoppingCart/css/register.css">
</head>
<body>
<form action = "/ShoppingCart/jsp/forgotPasswordValidation.jsp" method ="post">
<div class="box" >
<h4 ><b>Forgot Password</b></h4>

<table>
	
	<tr><td>Email:</td>
	<td> <input type ="text" placeholder ="Enter your email." name="email" required></td></tr>
	
	<tr><td>Phone Number:</td>
	<td> <input type ="text" placeholder ="Enter registered number." name="mobile" required></td></tr>
	
	<tr><td>Password:</td>
	<td> <input type ="text" placeholder ="Enter new password." name="password" required></td></tr>
	</table>
	<br><br>
	 <input class="one" type="submit" value ="Change Password">
      <button class="one" type="reset">Reset</button>
    

</div>
	</form>
	
</body>
</html>