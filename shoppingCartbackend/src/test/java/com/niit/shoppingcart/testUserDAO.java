package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

public class testUserDAO {
	  @Autowired
	  UserDAO userDAO;
	  @Autowired
	  User1 user;
	  @Autowired
	  AnnotationConfigApplicationContext context;
	
	public testUserDAO() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
        context.refresh();
		// context- bean factory
        user = (User1) context.getBean("user1");
		// Ask context to get the instance
		userDAO = (UserDAO) context.getBean("userDAOImpl");

		// getbean return object so typecasting

		
		

	}

	public User1 validate(String id, String pwd) {
		if (userDAO.validate(id,pwd)==null) {
			System.out.println("not valid");
			return user;
		} else {
			System.out.println("User exist");
			return user;

		}
	}

	public static void main(String[] args) 
	{
		testUserDAO t = new testUserDAO();
		t.validate("niit", "niit");
	}
}
	
	
		
		
		

