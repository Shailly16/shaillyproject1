package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product1;

public interface ProductDAO {
	
	
public List<Product1> list(); 
	
public Product1 get(String id);
public Product1 getByName(String name);
public void saveOrUpdate(Product1 product);
public boolean save(Product1 product); 
public boolean update(Product1 product);
public boolean delete(String id) ;
public Product1 getProductDetails();

}
