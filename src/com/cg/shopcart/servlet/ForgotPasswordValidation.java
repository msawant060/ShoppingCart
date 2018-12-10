package com.cg.shopcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Database;

@WebServlet("/forgotPassword")
public class ForgotPasswordValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForgotPasswordValidation() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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

		
	}

}
