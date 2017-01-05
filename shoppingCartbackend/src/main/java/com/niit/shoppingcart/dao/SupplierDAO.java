package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier1;

public interface SupplierDAO {
	
public List<Supplier1> list(); 
	
public Supplier1 get(String id);
	
public Supplier1 validate(String id);
	
public boolean save(Supplier1 Supplier1); 

public boolean update(Supplier1 Supplier1);

}
