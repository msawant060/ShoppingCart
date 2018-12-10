package com.cg.shopcart.dao;

import java.util.List;

import com.cg.shopcart.exception.ShoppingCartException;
import com.cg.shopcart.pojo.ProductPojo;

public interface ICart {

	public List<ProductPojo> getProduct(Integer cid) throws ShoppingCartException;
}
