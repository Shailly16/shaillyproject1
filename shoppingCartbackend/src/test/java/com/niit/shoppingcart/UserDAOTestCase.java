package com.niit.shoppingcart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User1;

import junit.framework.Assert;

public class UserDAOTestCase {

@Autowired
 static UserDAO userDAO;

@Autowired
 static User1 user;

@Autowired
 static AnnotationConfigApplicationContext context;

@BeforeClass
public static void init()
{
	context = new AnnotationConfigApplicationContext();
	//userDAO.validate("Chirutha", "Chirutha");
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	user = (User1) context.getBean("user1");
	userDAO =(UserDAO)context.getBean("userDAOImpl");

}


@Before
@Test
public void getUserTestCase()
{
	
	//user = userDAO.get("Chirutha");
	System.out.println("UID IS"+user.getId());
	Assert.assertEquals("user Test Case ","Chirutha",user.getId());
	
	
	//Assert statements
 // Assert.assertEquals("getUserTestCase","Chirutha", user.getId());
	
}
@Before
@Test
public void validateCredentials()
{
//user=	userDAO.validate("Chirutha", "Chirutha");
 Assert.assertNotNull("validateCredentials", userDAO.validate("Chirutha", "Chirutha"));
}


@Before
@Test
public void getAllUsersTestCase()
{
 int size=	userDAO.list().size();
 Assert.assertEquals(" length check ", 1 , size);
 
 
}

@Before
@Test
public void saveTestCase()
{
	
	//you have create /insert new row in db
	//provide values for user
	
	user.setId("Chirutha");
	user.setName("Chirutha");
	user.setContact("989898989");
	user.setMail("Chirutha@gmila.com");
	user.setPassword("Chirutha");
	user.setRole("ROLE_USER");
	
	
 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
	
}

@Before
@Test
public void updateTestCase()
{
	
	{
		
		
		user = userDAO.get("Chirutha");
		
		user.setMail("Sai@yahoo.com");
		
	 Assert.assertEquals("updateTestCase", true, 	userDAO.update(user));
		
		
	}
	
	
}}
