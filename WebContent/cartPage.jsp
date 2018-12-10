<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.cg.shopcart.dao.*" %>
    <%@ page import ="com.cg.shopcart.exception.*" %>
    <%@ page import ="com.cg.shopcart.pojo.*" %>
    <%@ page import ="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="center">
<tr>
    <th>Name</th>
    <th>Price</th>
</tr>

<%
List<ProductPojo> list= (ArrayList<ProductPojo>) request.getAttribute("list");

for (int i = 0; i < list.size(); i++) {
%>
   <td> <%=list.get(i).getDescription()%> </td>
   <td> <%=list.get(i).getPrice()%> </td></tr>  
<% } %>
</tr>  

</table>


</body>
</html>