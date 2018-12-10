<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.shopcart.pojo.ProductPojo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/ShoppingCart/css/MainPage.css">

</head>
<body>
	<form action="CartTableServlet">
		<table class="center">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Select items</th>
			</tr>

			<%
				List<ProductPojo> list = (ArrayList<ProductPojo>) request.getAttribute("list");

				for (int i = 0; i < list.size(); i++) {
			%>
			<td><%=list.get(i).getDescription()%></td>
			<td><%=list.get(i).getPrice()%></td>
			<td><input type="checkbox" name="checkItems"
				value="<%=list.get(i).getDescription()%>">
			<td>
			</tr>
			<%
				}
			%>


		</table>
		<input type="submit" value="Add to Cart" class="button">
	</form>
</body>
</html>