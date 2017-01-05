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

		// Ask context to get the instance
		userDAO = (UserDAO) context.getBean("userDAOImpl");

		// getbean return object so typecasting

		user = (User1) context.getBean("user1");
		context.close();

	}

	public boolean validate(String id, String pwd) {
		if (userDAO.validate(id,pwd)) {
			System.out.println("not valid");
			return false;
		} else {
			System.out.println("User exist");
			return true;

		}
	}

	public static void main(String[] args) {
		testUserDAO t = new testUserDAO();
		t.validate("niit", "niit");
	}
}
