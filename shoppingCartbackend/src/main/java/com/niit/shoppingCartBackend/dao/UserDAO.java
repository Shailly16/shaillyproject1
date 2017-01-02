package com.niit.shoppingCartBackend.dao;

import java.util.List;

import com.niit.shoppingCartBackend.model.User1;

public interface UserDAO {
 // method need to implement in other classes
// just only declare what to do
	
// What type of operations we required in DAO(CRUD OPERATIONS +VALIDATION)
	public List<User1> list(); // get all the User1s
	
	// getting User1 based on id
	public User1 get(String id);
	// checking whether the credentials are valid or not
	// if it is value it will return User1, else will return null
	public User1 validate(String id, String Password);
	
	// save(new registeration)
	public boolean save(User1 User1); // void will not tell if saved or not and boolean will tell yes or not
	
	// update
	public boolean update(User1 User1); // to save User1 need to pass User1 details in form (User1 User1)
	
}
