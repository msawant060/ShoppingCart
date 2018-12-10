package com.cg.shopcart.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.shopcart.dao.ConnectionFactory;
import com.cg.shopcart.exception.ExceptionMesssage;
import com.cg.shopcart.exception.ShoppingCartException;

public class ConnectionFactory {
	private static Connection connection = null;

	public static Connection getConnection() throws ShoppingCartException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system", "orcl11g");

		} catch (SQLException | ClassNotFoundException e) {
			throw new ShoppingCartException(ExceptionMesssage.MESSAGE1);
		}
		return connection;
	}

	public static void closeConnection() throws ShoppingCartException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new ShoppingCartException(ExceptionMesssage.MESSAGE1);
		}
	}

//	public static void main(String[] args) throws ShoppingCartException {
//		System.out.println(ConnectionFactory.getConnection());
//	}
}