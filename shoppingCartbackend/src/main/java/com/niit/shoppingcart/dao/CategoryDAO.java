package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category1;

public interface CategoryDAO {
	
	public List<Category1> list(); 
	
	public Category1 get(String id);
	public Category1 getCategoryByName(String name) ;
	public Category1 getCategoryDetails();
	public boolean save(Category1 category); 
	public void delete(String id) ;

	public boolean update(Category1 category);


}
