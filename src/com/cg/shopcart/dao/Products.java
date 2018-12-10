package com.cg.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.shopcart.exception.ExceptionMesssage;
import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

public class Products implements IProducts {
	
	@Override
	public List<ProductPojo> getAllProduct() throws ShoppingCartException {
		Connection connection = ConnectionFactory.getConnection();
	
		PreparedStatement statement = null;//-----------
		ResultSet set = null;//-------------------
		
		List<ProductPojo> listproducts = new ArrayList<>();

		String query = "select description,price from product";
		
		try {
			statement = connection.prepareStatement(query);
			set = statement.executeQuery();
			while (set.next()) {
				// https://stackoverflow.com/a/1832524/6775760

				ProductPojo product = new ProductPojo();
				product.setDescription(set.getString("description"));
				product.setPrice(set.getInt("price"));
				listproducts.add(product);

			}
		} catch (SQLException e) {
			throw new ShoppingCartException(ExceptionMesssage.MESSAGE2);
		}

		return listproducts;
	}

	/* public static void main(String[] args) throws ShoppingCartException {

	 Products cart = new Products();
		 
 List<ProductPojo> list = cart.getAllProduct();
	
	 for (ProductPojo products : list) {
 System.out.println(products.getDescription()+"\t"+products.getPrice());
 }
 
 
for (int i = 0; i < list.size(); i++) {
%>
   <td><%=list.get(i)%></td>
<% } %>
</tr>  

 }*/
}
