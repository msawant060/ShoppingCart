package com.cg.shopcart.utility;

import com.cg.shopcart.dao.IProducts;
import com.cg.shopcart.dao.Products;

public class ProductDOAUtility {
	
	public static IProducts getProductDAO(){
   	 return new Products();
    }
}
