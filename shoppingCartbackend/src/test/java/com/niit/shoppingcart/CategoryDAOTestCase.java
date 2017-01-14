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
	private static CategoryDAO categoryDAO;

	@Autowired
	private static Category1 category;

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		category = (Category1) context.getBean("category1");
		categoryDAO =(CategoryDAO)context.getBean("categoryDAOImpl");

	}
	
	@Test
	public void getCategoryTestCase()
	{  
	 //assert statements
	System.out.println("UID IS"+category.getId());
	Assert.assertEquals("Category Test Case ","LP001",category.getId());
	}
	
	
	
	
	@Test
	public void getAllCategoryTestCase()
	 {
		int size=categoryDAO.list().size();
		Assert.assertEquals("length check",8,size);
	 }
	
	@Before
	@Test
	public void saveTestCase()
	{
		
		category.setId("LP001");
		category.setName("My_vanity");
		category.setDescription("need of every woman");
		
		Assert.assertEquals("saveTestCase", true, categoryDAO.save(category));
		
	}
	
	@Test
	public void updateTestCase()
	{
		// giving id is mandatory as it is primary key.
		{
		category= categoryDAO.get("LP001");
		
		category.setName("Glow_House");
		Assert.assertEquals("updateTestCase", true, categoryDAO.update(category));
		
	}
	}
}




	

		
	
	
