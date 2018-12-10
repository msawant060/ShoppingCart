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

public class Cart implements ICart {

	@Override
	public List<ProductPojo> getProduct(Integer cid)
			throws ShoppingCartException {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = null;
		ResultSet set = null;
		
		List<ProductPojo> listproductsincart = new ArrayList<>();

		String query = "select description,price from product join cart on product.productid=cart.productid where cid=?";
		try {
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, cid);
			
			set = statement.executeQuery();

			while (set.next()) {
				// https://stackoverflow.com/a/1832524/6775760

				ProductPojo product = new ProductPojo();
				product.setDescription(set.getString("description"));
				product.setPrice(set.getInt("price"));
				listproductsincart.add(product);

			}
		} catch (SQLException e) {
			throw new ShoppingCartException(ExceptionMesssage.MESSAGE2);
		}

		return listproductsincart;
	}

	/*
	 * @Override public List<Object>[] getProduct(Integer cid) throws
	 * ShoppingCartException {
	 * 
	 * Connection connection = ConnectionFactory.getConnection();
	 * 
	 * String query =
	 * "select description,price from product join cart on product.productid=cart.productid where cid=?"
	 * ; List<Object> productListname = new ArrayList<>(); List<Object>
	 * productListprice = new ArrayList<>(); List<Object>[] productlist = new
	 * List[2];
	 * 
	 * try { PreparedStatement preparedStatement; preparedStatement =
	 * connection.prepareStatement(query); preparedStatement.setInt(1, cid);
	 * 
	 * ResultSet set = preparedStatement.executeQuery();
	 * 
	 * while (set.next()) { String stringresult = set.getString(1); int
	 * intresult = set.getInt(2); productListname.add(stringresult);
	 * productListprice.add(intresult); }
	 * 
	 * productlist[0] = productListname; productlist[1] = productListprice;
	 * 
	 * } catch (SQLException e) { throw new
	 * ShoppingCartException(ExceptionMesssage.MESSAGE2); } return productlist;
	 * }
	 */
	/*public static void main(String[] args) throws ShoppingCartException {
		Cart cart = new Cart();
		List<ProductPojo> list = cart.getProduct(1);
		
		for (ProductPojo products : list) {
			System.out.println(products.getDescription()+"\t"+products.getPrice());
		}
		
//		for (int i = 0; i < list[0].size(); i++) {
//			System.out.println(list[0].get(i) + "\t"
//					+ (((int) list[1].get(i)) + 100));
//		}
	}*/
}