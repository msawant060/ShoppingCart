<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "com.cg.shopcart.dao.*" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String email =request.getParameter("email");
String mobileNo =request.getParameter("mobile");//number in html and varchar in sql
String password =request.getParameter("password");

boolean status = Database.forgotPassword(email, mobileNo, password);
//System.out.println(status);

RequestDispatcher reqD = null;
if(status == true){
	reqD = request.getRequestDispatcher("/jsp/signin.jsp");
	reqD.forward(request, response);
}
else {
	response.sendRedirect("/ShoppingCart/jsp/forgotPassword.jsp");
}

%>
</body>
</html>