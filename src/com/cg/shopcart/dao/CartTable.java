package com.cg.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.shopcart.exception.ExceptionMesssage;
import com.cg.shopcart.exception.ShoppingCartException;

public class CartTable {

//	public static void main(String[] args) throws ShoppingCartException {
//	
//		CartTable cart = new CartTable();
//		
//		
//		cart.addToCart(3,1);
//	}

	//------------------------------------------------------------------------------------------
	public void addToCart(int productid,int customerid) throws ShoppingCartException {

		Connection connection = ConnectionFactory.getConnection();
		
		String query = "insert into cart values (?,?) ";
		
		try {
			
			PreparedStatement preparedStatement;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(2, customerid);
			preparedStatement.setInt(1, productid);
			preparedStatement.executeQuery();

			} catch (SQLException e) {
			throw new ShoppingCartException(ExceptionMesssage.MESSAGE2);
		}
	}
}
