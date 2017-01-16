package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category1;

public interface CategoryDAO {
	
	public List<Category1> list(); 
	public Category1 get(String id);
	public void saveOrUpdate(Category1 category);
	public Category1 getByName(String name);
	public boolean save(Category1 category); 
	public boolean delete(String id) ;
    public boolean update(Category1 category);


}
