package com.niit.shoppingcart.dao;


import java.util.List;

import com.niit.shoppingcart.model.Cart;


public interface CartDAO {
	
	Cart getCartById(int cartId);

	
	
	public List<Cart> list(String id);
	
	public void save(Cart MyCart);
	
	public void delete(Cart MyCart);
	
	public void updateCart(Cart MyCart); 
	
	public long getTotalAmount(String id);

}
