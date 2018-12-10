package com.cg.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.shopcart.dao.ConnectionFactory;
import com.cg.shopcart.exception.ShoppingCartException;

public class Database  {

	
	
	public static boolean insertNewUser(String name, String email, String mobileNo, String address, String password ) throws ShoppingCartException{
		 Connection connection = ConnectionFactory.getConnection();
		boolean status2=false;
		try{
			System.out.println("helloinsert");
		PreparedStatement statement = connection.prepareStatement("insert into customer values (customer_sequence.nextval, ?,?,?,?,?)");
		statement.setString(1, name);
		statement.setString(2, email);
		statement.setString(3, mobileNo);
		statement.setString(4, address);
		statement.setString(5, password);
		
		statement.executeUpdate();
		System.out.println("done");
		status2=true;
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return status2;
	}
	
	public static boolean canloginUser(String userName, String password) throws ShoppingCartException{
		boolean status2 = false;
		try {
			 Connection connection = ConnectionFactory.getConnection();

		 PreparedStatement statement = connection.prepareStatement("select * from customer where email =? and password =?");
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet set = statement.executeQuery();
			
				if (set.next()) {
						
					status2 = true;
					} 
				

		 } catch (SQLException e) {
			e.printStackTrace();
		} 

		return status2;
		
	}
	
	public static boolean forgotPassword(String email, String mobileNo, String password) throws ShoppingCartException{
		 Connection connection = ConnectionFactory.getConnection();

		boolean status = false;
		PreparedStatement statement;
	
		try {
			 statement = connection.prepareStatement("Select name from customer where email =? and phoneNumber =?");
			 
				statement.setString(1,email);
				statement.setString(2,mobileNo);
				ResultSet set = statement.executeQuery();
				if(set.next()){
					statement = connection.prepareStatement("update customer set password =? where email =? and phoneNumber=?");
					statement.setString(1,password);
					statement.setString(2,email);
					statement.setString(3,mobileNo);
					statement.executeUpdate();
					System.out.println("sahi aadmi hai isse jane do");
					status = true;
				}
				else{
					System.out.println("roko bc ko");
					status = false;
				}
				
				//System.out.println(status);
				
			 } catch (SQLException e) {
				e.printStackTrace();
			} 
		
		return status;
	}
}
