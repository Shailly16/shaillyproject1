package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.MyCart;

public interface CartDAO {
	
	public List<MyCart> list(String id);
	
	public void save(MyCart MyCart);
	
	public long getTotalAmount(String id);

}
