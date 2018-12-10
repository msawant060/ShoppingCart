package com.cg.shopcart.dao;

import java.util.List;

import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

public interface IProducts {
	public List<ProductPojo> getAllProduct() throws ShoppingCartException;
}
