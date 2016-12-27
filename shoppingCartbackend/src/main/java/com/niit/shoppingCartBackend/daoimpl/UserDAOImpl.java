package com.niit.shoppingCartBackend.daoimpl;

import com.niit.shoppingCartBackend.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	public boolean isValidCredentials(String id, String password) {
		// Test against db
		if(id.equals("niit") && password.equals("niit@123"))
		{ return true;
		}
		else{
		return false;
	}

}}
