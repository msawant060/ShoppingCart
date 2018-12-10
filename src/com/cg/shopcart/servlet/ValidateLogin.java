package com.cg.shopcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Database;

@WebServlet(description = "This helps in User Validation for Login Page", urlPatterns = { "/validate" })
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ValidateLogin() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean status = Database.canloginUser(userName, password);

		RequestDispatcher reqD = null;
		if (status == true) {
			reqD = request.getRequestDispatcher("/ProductsServlet");
			reqD.forward(request, response);
		} else {response.sendRedirect("/ShoppingCart/jsp/signin.jsp");
		}
		out.print(status);
	}

}
