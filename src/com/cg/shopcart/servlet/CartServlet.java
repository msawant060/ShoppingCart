package com.cg.shopcart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Cart;
import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post");
		Cart cart = new Cart();

		try {
			List<ProductPojo> productinCart = cart.getProduct(21);
			request.setAttribute("list", productinCart);
			request.getRequestDispatcher("/cartPage.jsp").forward(request,
					response);
		} catch (ShoppingCartException e) {
			e.printStackTrace();

		}

	}
}
