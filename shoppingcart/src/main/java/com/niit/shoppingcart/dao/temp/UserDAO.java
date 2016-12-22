package com.niit.shoppingcart.dao.temp;

public class UserDAO {
	

	public boolean isValidCredentials(String id, String Password)
	{
		if (id.equals("niit") && Password.equals("niit@123"))
		{ return true;
	}
		else
		{ 
			return false;
		}
}
}
