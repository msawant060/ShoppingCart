package com.cg.shopcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Database;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserRegistration() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String email =request.getParameter("email");
		String mobileNo =request.getParameter("mobile");//number in html and varchar in sql
		String address =request.getParameter("address");
		String password =request.getParameter("password");

		boolean status = Database.insertNewUser(name, email, mobileNo, address, password);

		if (status==true){
			response.sendRedirect("/ShoppingCart/jsp/signin.jsp");
		}
	}

}
