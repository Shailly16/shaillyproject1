/*package com.niit.shoppingcart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class userTestCase {
	@Autowired
	 static UserDAO userDAO1;

	@Autowired
	 static User user1;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		user1 = (User) context.getBean("user");
		userDAO1 =(UserDAO)context.getBean("userDAOImpl");

	}
	
	@Test
	public void getuserTestCase()
	{ 
	 //assert statements
	System.out.println("UID IS"+user1.getId());
	Assert.assertEquals("US001",user1.getId());
	}
	
	@Test
	public void validateCredentials()
	{
	
	 Assert.assertNotNull("validateCredentials", userDAO1.validate("US001", "passer"));
	}

	
	
	@Test
	public void saveTestCase()
	{
		
		user1.setId("US001");
		user1.setName("MAC_Beauty");
		user1.setContact("8945752315");
		user1.setEmail("sai@gmail.com");
		user1.setPassword("passer");
		user1.setRole("ROLE_ADMIN");
		
		Assert.assertEquals( "saveTestCase", true, userDAO1.save(user1));
		
	}
	
	
	
	@Test
	public void getAlluserTestCase()
	 {
		
		int size=userDAO1.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		user1= userDAO1.get("US001");
		
		user1.setName("Glow_House");
		Assert.assertEquals( true, userDAO1.update(user1));
		
	}
	}




	
*/