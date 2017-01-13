package com.niit.shoppingcart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category1;

import junit.framework.Assert;

public class CategoryDAOTestCase {
	@Autowired
	 static CategoryDAO categoryDAO;

	@Autowired
	 static Category1 category;

	@Autowired
	 static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		category = (Category1) context.getBean("category1");
		categoryDAO =(CategoryDAO)context.getBean("categoryDAOImpl");

	}
	@Before
	@Test
	public void getCategoryTestCase()
	{ //category=categoryDAO.get("NIITPV");  
	 //assert statements
	System.out.println("UID IS"+category.getId());
	Assert.assertEquals("Category Test Case ","LP001",category.getId());// niit is expected whereas category.getName() will give the entered actual input.
	//Assert.assertNotNull("getCategoryTestCase", category);// categoryDAO must not return null object.
	}
	@Before
	@Test
	public void getAllCategoryTestCase()
	 {
		int size = categoryDAO.list().size();
		Assert.assertEquals("length check",1,size);
	 }
	@Before
	@Test
	public void saveTestCase()
	{
		
		category.setId("LP001");
		category.setName("Vanity");
		category.setDescription("Every woman need");
		
		Assert.assertEquals("saveTestCase", true, categoryDAO.save(category));
		
	}
	@Before
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		category= categoryDAO.get("LP001");
		
		category.setName("My_Vanity");
		Assert.assertEquals("updateTestCase", true, categoryDAO.update(category));
		
	}
	}




	
