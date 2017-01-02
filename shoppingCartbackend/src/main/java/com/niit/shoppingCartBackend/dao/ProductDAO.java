package com.niit.shoppingCartBackend.dao;

import java.util.List;

import com.niit.shoppingCartBackend.model.Product1;

public interface ProductDAO {
	
	
public List<Product1> list(); 
	
public Product1 get(String id);
		
public Product1 validate(String id);
		
public boolean save(Product1 Product1); 

public boolean update(Product1 Product1);

}
