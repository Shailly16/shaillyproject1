package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier1;

public interface SupplierDAO {
	
public List<Supplier1> list(); 
	
public Supplier1 get(String id);
	
public void delete(String id) ;
public Supplier1 getSupplierByName(String name);
public Supplier1 getSupplierDetails();
	
public boolean save(Supplier1 supplier); 

public boolean update(Supplier1 supplier);

}
