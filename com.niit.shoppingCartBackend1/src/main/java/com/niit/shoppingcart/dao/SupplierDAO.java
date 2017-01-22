package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {
	
public List<Supplier> list(); 
	
public Supplier get(String id);
	
public boolean delete(String id) ;
public Supplier getByName(String name);
public Supplier getSupplierDetails();
public void saveOrUpdate(Supplier supplier1);	
public boolean save(Supplier supplier1); 

public boolean update(Supplier supplier1);

}

