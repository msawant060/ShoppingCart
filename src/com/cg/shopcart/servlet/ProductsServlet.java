package com.cg.shopcart.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.shopcart.dao.Products;
import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		Products products=new Products();//<<-------------------------------------Interface?

		try {
			List<ProductPojo> productlist = products.getAllProduct();
			
			request.setAttribute("list", productlist);
			request.getRequestDispatcher("/1homepage.jsp").forward(request,response);
		} catch (ShoppingCartException e) {
			e.printStackTrace();
		}
	}
}

