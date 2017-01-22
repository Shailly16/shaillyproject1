package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;

public class categoryTestCase {
	@Autowired
	 static CategoryDAO categoryDAO1;

	@Autowired
	 static Category category1;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		category1 = (Category) context.getBean("category");
		categoryDAO1 =(CategoryDAO)context.getBean("categoryDAOImpl");

	}
	
	@Test
	public void getcategoryTestCase()
	{ 
	 //assert statements
	System.out.println("UID IS"+category1.getCid());
	Assert.assertEquals("CA001",category1.getCid());
	}
	
	
	@Test
	public void saveTestCase()
	{
		
		category1.setCid("CA001");
		category1.setName("MAC_Beauty");
		category1.setAddress(" House No.1,25Street,Boston,USA_201036 ");
		
		Assert.assertEquals( "saveTestCase", true, categoryDAO1.save(category1));
		
	}
	
	
	
	@Test
	public void getAllcategoryTestCase()
	 {
		
		int size=categoryDAO1.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		category1= categoryDAO1.get("CA001");
		
		category1.setName("Glow_House");
		Assert.assertEquals( true, categoryDAO1.update(category1));
		
	}
	}




	
