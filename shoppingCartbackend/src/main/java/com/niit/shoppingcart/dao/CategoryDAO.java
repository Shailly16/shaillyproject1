package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category1;

public interface CategoryDAO {
	
	public List<Category1> list(); 
	
	public Category1 get(String id);
			
	public Category1 validate(String id);
			
	public boolean save(Category1 Category1); 

	public boolean update(Category1 Category1);


}
