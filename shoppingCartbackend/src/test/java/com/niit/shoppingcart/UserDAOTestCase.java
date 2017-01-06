package com.niit.shoppingcart;




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
	
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	user = (User1) context.getBean("user1");
	userDAO =(UserDAO)context.getBean("userDAOImpl");

}



@Test
public void getUserTestCase()
{ //user=userDAO.get("NIITPV");  
 //assert statements
System.out.println("UID IS"+user.getId());
Assert.assertEquals("User Test Case ","arpita1",user.getId());// niit is expected whereas user.getName() will give the entered actual input.
//Assert.assertNotNull("getUserTestCase", user);// userDAO must not return null object.
}
@Test
public void validateCredentials()
{
	//user= userDAO.validate("arpit", "sai");
	//System.out.println("uide is"+user.getPassword());
	Assert.assertNotNull("validate test case",userDAO.validate("arpita1", "sai"));
	System.out.println("uide is"+user.getPassword());
	
}

public void getAllUsersTestCase()
 {
	int size = userDAO.list().size();
	Assert.assertEquals("length check",1,size);
 }
@Test
public void saveTestCase()
{
	
	user.setId("arpita1");
	user.setName("arpita");
	user.setContact("987256478");
	user.setMail("sai@gmail.com");
	user.setPassword("sai");
	user.setRole("admin");
	Assert.assertEquals("saveTestCase", true, userDAO.save(user));
	
}
@Test
public void updateTestCase()
{
	// giving id is mandatory as it is primary key.
	
	user= userDAO.get("arpita1");
	
	user.setRole("customer");
	Assert.assertEquals("updateTestCase", true, userDAO.update(user));
	
}
}
