package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {
	
 public Order get(String id);
 
 public Long getTotalAmount(String id);

}
