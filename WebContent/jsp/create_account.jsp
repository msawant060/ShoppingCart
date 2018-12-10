<%@page import="com.cg.shopcart.dao.ConnectionFactory"%>
<%@ page import ="com.cg.shopcart.dao.Database" %>
<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>validate page</title>
</head>
<body>


<%
String name =request.getParameter("name");
String email =request.getParameter("email");
String mobileNo =request.getParameter("mobile");//number in html and varchar in sql
String address =request.getParameter("address");
String password =request.getParameter("password");

boolean status = Database.insertNewUser(name, email, mobileNo, address, password);

if (status==true){
	response.sendRedirect("/ShoppingCart/jsp/signin.jsp");
}


%>


</body>
</html>