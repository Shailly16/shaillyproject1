package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
	
public List<Product> list(); 
	
public Product get(String id);
	
public void delete(String id) ;
public Product getByName(String name);
public Product getProductDetails();

public boolean save(Product product1); 

public boolean update(Product product1);



}

