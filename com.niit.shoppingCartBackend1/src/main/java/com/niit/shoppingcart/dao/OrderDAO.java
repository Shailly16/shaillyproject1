package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {
	
 public Order get(String id);
 public List<Order> list();
 public Long getTotalAmount(String id);

}
