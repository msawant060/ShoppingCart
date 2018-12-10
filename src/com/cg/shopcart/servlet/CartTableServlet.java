package com.cg.shopcart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Cart;
import com.cg.shopcart.dao.CartTable;
import com.cg.shopcart.dao.Products;
import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

@WebServlet("/CartTableServlet")
public class CartTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartTable cartTable = new CartTable();// <<-------------------------------------Interface?
		String productarray[] = request.getParameterValues("checkItems");
		// int customerid = request.getParameter();<<-----------

		List<ProductPojo> productlist = null;

		try {
			for (int i = 0; i < productarray.length; i++) {
				productlist.add(cartTable.addToCart(productarray[i], customerid));
					
			}
			
			request.setAttribute("list", productlist);
			request.getRequestDispatcher("/1homepage.jsp").forward(request,
					response);
		} catch (ShoppingCartException e) {
			e.printStackTrace();
		}
	}

}
